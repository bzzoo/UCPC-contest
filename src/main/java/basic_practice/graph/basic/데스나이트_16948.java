package basic_practice.graph.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 데스나이트_16948 {

    static int N;
    static int[] nightOne, nightTwo;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nightOne = new int[3];
        nightTwo = new int[2];

        nightOne[0] = sc.nextInt();
        nightOne[1] = sc.nextInt();
        nightTwo[0] = sc.nextInt();
        nightTwo[1] = sc.nextInt();

        func();
    }

    static void func() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][N + 1];

        q.offer(nightOne);
        visited[nightOne[0]][nightOne[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == nightTwo[0] && now[1] == nightTwo[1]) {
                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                int nd = now[2] + 1;

                if (nr < 0 || nc < 0 || nr > N || nc > N || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, nd});
            }
        }
        System.out.println(-1);
    }
}
