package basic_practice.graph.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이_1600 {

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[] hr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][W];
        visited = new boolean[H][W][K + 1]; // 평행세계
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();
                int r = now[0], c = now[1], k = now[2];

                if (r == H - 1 && c == W - 1) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (isInRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][k]) {
                        visited[nr][nc][k] = true;
                        q.add(new int[]{nr, nc, k});
                    }
                }


                if (k < K) {
                    for (int i = 0; i < 8; i++) {
                        int nr = r + hr[i];
                        int nc = c + hc[i];

                        if (isInRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][k + 1]) {
                            visited[nr][nc][k + 1] = true;
                            q.add(new int[]{nr, nc, k + 1});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    static boolean isInRange(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }
}
