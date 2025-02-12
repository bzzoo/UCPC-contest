package basic_practice.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트택시_19238 {

    static int N, M, K;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[] taxi;
    static Custom[] customs;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        taxi = new int[]{sc.nextInt() - 1, sc.nextInt() - 1, K, -1};

        customs = new Custom[M];
        for (int i = 0; i < M; i++) {
            customs[i] = new Custom(
                    i,
                    sc.nextInt() - 1,
                    sc.nextInt() - 1,
                    sc.nextInt() - 1,
                    sc.nextInt() - 1,
                    false);
        }

        while (!isAllArrive()) {
            if (!searchCustom()) {
                System.out.println(-1);
                return;
            }
            if (taxi[2] < 0) {
                System.out.println(-1);
                return;
            }

            if (!toDestination()) {
                System.out.println(-1);
                return;
            }
            if (taxi[2] < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(taxi[2]);
    }

    static boolean isAllArrive() {
        for (Custom custom : customs) {
            if (!custom.isArrive) return false;
        }
        return true;
    }

    static boolean toDestination() {
        int startFuel = taxi[2];
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(taxi.clone());
        visited[taxi[0]][taxi[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[2] < 0) continue;

            if (customs[now[3]].ar == now[0] && customs[now[3]].ac == now[1]) {
                customs[now[3]].isArrive = true;
                taxi = new int[]{now[0], now[1], now[2] + (startFuel - now[2]) * 2, -1};
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                int nf = now[2] - 1;

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (map[nr][nc] == 1 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, nf, now[3]});
            }
        }
        return false;
    }

    static boolean searchCustom() {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(taxi.clone());
        visited[taxi[0]][taxi[1]] = true;

        LinkedList<int[]> candidates = new LinkedList<>();
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] now = q.poll();

                if (now[2] < 0) continue;

                for (Custom custom : customs) {
                    if (custom.isArrive) continue;
                    if (custom.r == now[0] && custom.c == now[1]) {
                        candidates.add(new int[]{now[0], now[1], now[2], custom.idx});
                        found = true;
                    }
                }
                if (found) continue;

                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    int nf = now[2] - 1;

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, nf, -1});
                }
            }
            if (found) break;
        }

        if (candidates.isEmpty()) return false;
        candidates.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] chosen = candidates.getFirst();
        taxi = chosen.clone();
        taxi[3] = chosen[3];
        return true;
    }


    static class Custom {
        int idx;
        int r, c;
        int ar, ac;
        boolean isArrive;

        public Custom(int idx, int r, int c, int ar, int ac, boolean isArrive) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.ar = ar;
            this.ac = ac;
            this.isArrive = isArrive;
        }
    }
}
