package basic_practice.graph.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레이저통신_6087 {

    static int[] dx = {-1, 0, 1, 0};  // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int H, W;

    static class State {
        int x, y, dir, mirrors;

        State(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new char[H][W];

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'C') {
                    points.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs(points.get(0), points.get(1)));
    }

    static int bfs(int[] start, int[] end) {
        Queue<State> queue = new LinkedList<>();
        int[][][] visited = new int[H][W][4];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        for (int dir = 0; dir < 4; dir++) {
            queue.offer(new State(start[0], start[1], dir, 0));
            visited[start[0]][start[1]][dir] = 0;
        }

        int minMirrors = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.x == end[0] && curr.y == end[1]) {
                minMirrors = Math.min(minMirrors, curr.mirrors);
                continue;
            }

            for (int newDir = 0; newDir < 4; newDir++) {
                if (Math.abs(curr.dir - newDir) == 2) continue;

                int nx = curr.x + dx[newDir];
                int ny = curr.y + dy[newDir];

                if (!isValid(nx, ny)) continue;

                int newMirrors = curr.mirrors;
                if (curr.dir != newDir) {
                    newMirrors++;
                }

                if (visited[nx][ny][newDir] > newMirrors) {
                    visited[nx][ny][newDir] = newMirrors;
                    queue.offer(new State(nx, ny, newDir, newMirrors));
                }
            }
        }

        return minMirrors;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W && board[x][y] != '*';
    }
}