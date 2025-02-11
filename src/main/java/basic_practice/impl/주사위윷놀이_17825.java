package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위윷놀이_17825 {

    static int[] dice = new int[10];
    static int answer = 0;
    static Node[] nodes;
    static int[] horses = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        initializeBoard();
        func(0, 0);
        System.out.println(answer);
    }

    static void func(int depth, int score) {
        if (depth == 10) {
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (horses[i] == 32) continue;

            int now = horses[i];
            int next;

            if (nodes[now].prime != null) {
                int temp = nodes[now].prime;
                for (int j = 0; j < dice[depth] - 1; j++) {
                    if (temp == 32) {
                       break;
                    }
                    temp = nodes[temp].next;
                }
                next = temp;
            } else {
                next = now;
                for (int j = 0; j < dice[depth]; j++) {
                    if (next == 32) {
                        break;
                    }
                    next = nodes[next].next;
                }
            }

            if (isOverlaped(next, i)) continue;

            horses[i] = next;
            func(depth + 1, score + (next == 32 ? 0 : nodes[next].score));
            horses[i] = now;
        }
    }

    static boolean isOverlaped(int nowHorse, int currentHorseIndex) {
        if (nowHorse == 32) return false;

        for (int i = 0; i < 4; i++) {
            if (i == currentHorseIndex) continue;
            if (horses[i] == nowHorse) return true;
        }
        return false;
    }

    static void initializeBoard() {
        nodes = new Node[33];

        nodes[0] = new Node(0, 1);
        nodes[32] = new Node(0, 32);

        for (int i = 1; i <= 19; i++) {
            nodes[i] = new Node(i * 2, i + 1);
        }

        for (int i = 21; i <= 31; i++) {
            nodes[i] = new Node();
        }
        nodes[20] = new Node(40, 32);

        nodes[5].prime = 21;
        nodes[10].prime = 26;
        nodes[15].prime = 29;
        nodes[24].prime = 30;

        nodes[21].next = 22;
        nodes[22].next = 23;
        nodes[23].next = 24;
        nodes[26].next = 25;
        nodes[25].next = 24;
        nodes[29].next = 28;
        nodes[28].next = 27;
        nodes[27].next = 24;
        nodes[24].next = 30;

        nodes[30].next = 31;
        nodes[31].next = 20;

        nodes[21].score = 13;
        nodes[22].score = 16;
        nodes[23].score = 19;
        nodes[24].score = 25;
        nodes[25].score = 24;
        nodes[26].score = 22;
        nodes[27].score = 26;
        nodes[28].score = 27;
        nodes[29].score = 28;
        nodes[30].score = 30;
        nodes[31].score = 35;
    }

    static class Node {
        int score;
        int next;
        Integer prime;

        public Node() {}

        public Node(int score, int next) {
            this.score = score;
            this.next = next;
        }
    }
}