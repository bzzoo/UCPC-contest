package basic_practice.graph.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백조의호수_3197 {

    static int R, C;
    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> lakes = new ArrayList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static Queue<int[]> nextSwanQueue = new LinkedList<>();
    static Queue<int[]> iceQueue = new LinkedList<>();
    static Queue<int[]> nextIceQueue = new LinkedList<>();
    static boolean[][] visitedSwan;
    static boolean[][] visitedIce;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedSwan = new boolean[R][C];
        visitedIce = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    lakes.add(new int[]{i, j});
                }
                if (map[i][j] != 'X') {
                    visitedIce[i][j] = true;
                    iceQueue.add(new int[]{i, j});
                }
            }
        }

        swanQueue.add(lakes.get(0));
        visitedSwan[lakes.get(0)[0]][lakes.get(0)[1]] = true;

        int days = 0;
        while (true) {
            if (swanBFS()) {
                break;
            }
            meltIce();
            days++;
        }

        System.out.println(days);
    }

    static boolean swanBFS() {
        while (!swanQueue.isEmpty()) {
            int[] current = swanQueue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visitedSwan[nr][nc]) continue;
                visitedSwan[nr][nc] = true;

                if (map[nr][nc] == 'L') return true;

                if (map[nr][nc] == '.') {
                    swanQueue.add(new int[]{nr, nc});
                } else if (map[nr][nc] == 'X') {
                    nextSwanQueue.add(new int[]{nr, nc});
                }
            }
        }
        swanQueue = nextSwanQueue;
        nextSwanQueue = new LinkedList<>();
        return false;
    }

    static void meltIce() {
        while (!iceQueue.isEmpty()) {
            int[] current = iceQueue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visitedIce[nr][nc]) continue;
                visitedIce[nr][nc] = true;

                if (map[nr][nc] == 'X') {
                    nextIceQueue.add(new int[]{nr, nc});
                    map[nr][nc] = '.';
                }
            }
        }
        iceQueue = nextIceQueue;
        nextIceQueue = new LinkedList<>();
    }
}
