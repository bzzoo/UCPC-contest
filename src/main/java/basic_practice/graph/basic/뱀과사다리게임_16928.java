package basic_practice.graph.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임_16928 {

    static int N, M;
    static Map<Integer, Integer> ladders, snakes;
    static Board[] board;

    public static void main(String[] args) {
        input();
        func();
        System.out.println(board[100].min);
    }

    public static void func() {
        Queue<Board> q = new LinkedList<>();
        q.add(board[1].updateMin(0));

        while (!q.isEmpty()) {
            Board now = q.poll();
            if(now.idx > 100) continue;
            //System.out.println("idx: " + now.idx + "min:" + now.min);
            for (int i = 1; i <= 6; i++) {
                if(now.idx + i > 100) continue;
                Board next = board[now.idx + i];
                if (next.min <= now.min + 1) continue;
                next.updateMin(now.min + 1);

                if (next.snake != 0) {
                    q.add(board[next.snake].updateMin(now.min + 1));
                    continue;
                }
                if (next.ladder != 0) {
                    q.add(board[next.ladder].updateMin(now.min + 1));
                } else {
                    q.add(next);
                }
            }
        }
    }

    static class Board {

        int idx;
        int ladder;
        int snake;
        int min = Integer.MAX_VALUE;

        public Board(int idx) {
            this.idx = idx;
        }

        public Board(int idx, int ladder, int snake) {
            this.idx = idx;
            this.ladder = ladder;
            this.snake = snake;
        }

        public void initLadder(int ladder){
            this.ladder = ladder;
        }

        public void initSnake(int snake){
            this.snake = snake;
        }

        public Board updateMin(int value) {
            min = Math.min(min, value);
            return this;
        }
    }

    public static void input() {
        FastReader fastReader = new FastReader();
        N = fastReader.nextInt();
        M = fastReader.nextInt();

        board = new Board[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = new Board(i);
        }

        ladders = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int start = fastReader.nextInt();
            int end = fastReader.nextInt();
            ladders.put(start, end);
            board[start].initLadder(end);

        }

        snakes = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int start = fastReader.nextInt();
            int end = fastReader.nextInt();
            snakes.put(start, end);
            board[start].initSnake(end);
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }
    }
}
