package basic_practice.force;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어_16236 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};  // 상, 하, 좌, 우
    static int babySharkSize = 2;
    static int babySharkEatCount = 0;
    static int totalTime = 0;
    static int babySharkR, babySharkC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    babySharkR = i;
                    babySharkC = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int timeToEat = bfs();
            if (timeToEat == -1) break;
            totalTime += timeToEat;
        }

        System.out.println(totalTime);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        visited = new boolean[N][N];

        q.add(new int[]{babySharkR, babySharkC, 0});
        visited[babySharkR][babySharkC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if (map[nr][nc] > babySharkSize) continue;
                visited[nr][nc] = true;
                if (map[nr][nc] != 0 && map[nr][nc] < babySharkSize) {
                    pq.add(new Fish(nr, nc, dist + 1));
                }
                q.add(new int[]{nr, nc, dist + 1});
            }
        }

        if (pq.isEmpty()) {
            return -1;
        }

        Fish target = pq.poll();
        babySharkR = target.r;
        babySharkC = target.c;
        map[babySharkR][babySharkC] = 0;
        babySharkEatCount++;

        if (babySharkEatCount == babySharkSize) {
            babySharkSize++;
            babySharkEatCount = 0;
        }

        return target.dist;
    }

    static class Fish implements Comparable<Fish> {
        int r, c;
        int dist;

        public Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }
    }
}
