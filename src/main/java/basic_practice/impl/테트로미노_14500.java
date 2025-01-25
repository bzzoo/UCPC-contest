package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                func(i,j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    public static void func(int row, int col, int depth, int sum ){
        if(depth == 4){
            if(max < sum) max = sum;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if(visited[nr][nc]) continue;;

            if(depth == 2) {
                visited[nr][nc] = true;
                func(row,col,depth + 1,sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
            visited[nr][nc] = true;
            func(nr, nc, depth+1, sum+map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
