package basic_practice.impl;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class 열쇠_9328 {
    static int h, w;
    static char[][] building;
    static boolean[][] visited;
    static boolean[] keys;
    static List<int[]>[] doors;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();

            building = new char[h][w];
            visited = new boolean[h][w];
            keys = new boolean[26];
            doors = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            for (int i = 0; i < h; i++) {
                String line = sc.nextLine();
                building[i] = line.toCharArray();
            }

            String keyInput = sc.nextLine();
            if (!keyInput.equals("0")) {
                for (char key : keyInput.toCharArray()) {
                    keys[key - 'a'] = true;
                }
            }

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int documents = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                    if (building[i][j] != '*') {
                        q.add(new int[] {i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            char cell = building[x][y];

            if (cell == '$') {
                documents++;
                building[x][y] = '.';
            }

            if (cell >= 'a' && cell <= 'z') {
                int keyIndex = cell - 'a';
                keys[keyIndex] = true;
                building[x][y] = '.';

                for (int[] door : doors[keyIndex]) {
                    q.add(door);
                }
                doors[keyIndex].clear();
            }

            if (cell >= 'A' && cell <= 'Z') {
                int doorIndex = cell - 'A';
                if (!keys[doorIndex]) {
                    doors[doorIndex].add(new int[] {x, y});
                    continue;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visited[nx][ny] || building[nx][ny] == '*') continue;

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }

        return documents;
    }
}
