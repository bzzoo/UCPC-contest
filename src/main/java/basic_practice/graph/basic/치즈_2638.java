package basic_practice.graph.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 치즈_2638 {

    static int N, M, cheeseCnt, result;
    static int[][] map;
    static List<Point> cheese;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    private final static int OUT_AIR = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        cheese = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    cheese.add(new Point(i, j));
                    cheeseCnt++;
                }
            }
        }

        while(cheeseCnt > 0){
            result++;
            visited = new boolean[N][M];
            findOutAir(0,0);
            melt();
        }
        System.out.println(result);
    }

    static public void findOutAir(int r, int c) {
        visited[r][c] = true;
        map[r][c] = OUT_AIR;
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr <0 || nc < 0 || nr >=N || nc >= M) continue;
            if(visited[nr][nc] || map[nr][nc] == 1) continue;

            findOutAir(nr, nc);
        }
    }

    static public void melt(){
        for(int i = 0; i < cheese.size(); i++) {
            int r = cheese.get(i).r;
            int c = cheese.get(i).c;
            int cnt = 0;

            for(int j = 0; j < 4; j++) {
                int nr = r + dx[j];
                int nc = c + dy[j];

                if(map[nr][nc] == 2) {
                    cnt++;
                }
            }

            if(cnt >= 2) {
                map[r][c] = 0;
                cheeseCnt--;
                cheese.remove(i);
                i--;
            }
        }
    }
}

class Point {

    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
