package basic_practice.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 뻄_3190 {

    static int N, K, L;
    static int[][] map;
    static Deque<int[]> dq = new LinkedList<>();
    static HashMap<Integer, String> dir = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = 2; // 사과
        }

        L = sc.nextInt();

        for (int i = 0; i < L; i++) dir.put(sc.nextInt(), sc.next());


        dq.addFirst(new int[]{0, 0, 0, 1});
        map[0][0] = 1;
        int second = 0;
        while (true) {
            second++;
            int[] now = dq.peekFirst();
            int nr = now[0];
            int nc = now[1];
            int dr = now[2];
            int dc = now[3];
            String direction = dir.getOrDefault(second-1, "N");
            if(direction.equals("D")) {
                if(dr == 0 && dc == 1){
                    dr = 1; dc = 0;
                    nr+=dr;
                    nc+=dc;

                }
                else if(dr == 0 && dc == -1){
                    dr = -1; dc = 0;
                    nr+=dr;
                    nc+=dc;

                }
                else if(dr == 1 && dc == 0){
                    dr = 0; dc = -1;
                    nr+=dr;
                    nc+=dc;
                }
                else{
                    dr = 0; dc = 1;
                    nr+=dr;
                    nc+=dc;
                }
            } else if(direction.equals("L")){
                if(dr == 0 && dc == 1){
                    dr = -1; dc = 0;
                    nr+=dr;
                    nc+=dc;
                }
                else if(dr == 0 && dc == -1){
                    dr = 1; dc = 0;
                    nr+=dr;
                    nc+=dc;
                }
                else if(dr == 1 && dc == 0){
                    dr = 0; dc = 1;
                    nr+=dr;
                    nc+=dc;
                }
                else {
                    dr = 0; dc = -1;
                    nr+=dr;
                    nc+=dc;
                }
            } else {
                nr += dr;
                nc += dc;
            }

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
            if(map[nr][nc] == 1) break;
            if(map[nr][nc] == 0) {
                int[] last = dq.pollLast();
                map[last[0]][last[1]] = 0;
            }
            map[nr][nc] = 1;
            dq.addFirst(new int[] {nr, nc, dr, dc});
        }
        System.out.println(second);
    }
}
