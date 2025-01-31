package basic_practice.graph.basic;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기3_16933 {
    static int N, M, K;
    static int[][] map;
    static int[][][] dist;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k <= K; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0], c = now[1], broken = now[2];
            int curDist = dist[r][c][broken];

            if (r == N-1 && c == M-1) return curDist;

            boolean isDay = curDist % 2 == 1;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] == 1) {
                    if (broken < K && isDay && dist[nr][nc][broken + 1] == -1) {
                        dist[nr][nc][broken + 1] = curDist + 1;
                        q.offer(new int[]{nr, nc, broken + 1});
                    }
                    else if (!isDay && dist[r][c][broken] != curDist + 1) {
                        q.offer(new int[]{r, c, broken});
                        dist[r][c][broken] = curDist + 1;
                    }
                }

                else if (dist[nr][nc][broken] == -1) {
                    dist[nr][nc][broken] = curDist + 1;
                    q.offer(new int[]{nr, nc, broken});
                }
            }
        }
        return -1;
    }
}