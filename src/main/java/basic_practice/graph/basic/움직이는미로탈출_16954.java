package basic_practice.graph.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 움직이는미로탈출_16954 {

    static char[][] map;
    static final int MAP_SIZE = 8;
    static boolean[][][] visited;
    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new char[MAP_SIZE][MAP_SIZE];
        visited = new boolean[MAP_SIZE][MAP_SIZE][MAP_SIZE* MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(func() ? 1 : 0);
    }

    static boolean func() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{MAP_SIZE-1, 0, 0});
        visited[MAP_SIZE-1][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            if(x == 0 && y == MAP_SIZE-1) return true;

            for(int d = 0; d < 9; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= MAP_SIZE || ny >= MAP_SIZE) continue;
                if(visited[nx][ny][t+1]) continue;

                if(canMove(nx, ny, t)) {
                    visited[nx][ny][t+1] = true;
                    q.offer(new int[]{nx, ny, t+1});
                }
            }
        }
        return false;
    }

    static boolean canMove(int x, int y, int t) {
        if(isWall(x, y, t)) return false;
        if(x-1 >= 0 && isWall(x-1, y, t)) return false;
        return true;
    }

    static boolean isWall(int x, int y, int t) {
        int wallX = x - t;
        if(wallX < 0) return false;
        return map[wallX][y] == '#';
    }
}
