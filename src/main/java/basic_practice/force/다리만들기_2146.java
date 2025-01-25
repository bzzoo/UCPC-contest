package basic_practice.force;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기_2146 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    markIsland(i, j, islandId);
                    islandId++;
                }
            }
        }

        for (int id = 2; id < islandId; id++) {
            findShortestBridge(id);
        }

        System.out.println(answer);
    }

    private static void markIsland(int i, int j, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        map[i][j] = id;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (map[nr][nc] == 1) {
                    map[nr][nc] = id;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static void findShortestBridge(int islandId) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandId) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if (ni >= 0 && nj >= 0 && ni < N && nj < N && map[ni][nj] == 0) {
                            q.add(new int[]{i, j, 0});
                            visited[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0], c = now[1], dist = now[2];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;

                    if (map[nr][nc] == 0) {
                        q.add(new int[]{nr, nc, dist + 1});
                    } else if (map[nr][nc] > 1 && map[nr][nc] != islandId) {
                        answer = Math.min(answer, dist);
                        return;
                    }
                }
            }
        }
    }
}
