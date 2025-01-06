package graph.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 연구소_14502 {

    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        rec(0);
        System.out.println(max);
    }

    static public void rec(int depth){
        if(depth == 3){
            int[][] copyMap = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            int result = spread(copyMap);
            max = Math.max(max, result);
        }
        else{
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        rec(depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static public int spread (int[][] copyMap){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] virus = queue.poll();
            int x = virus[0];
            int y = virus[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return getSafeArea(copyMap);
    }

    static public int getSafeArea(int[][] copyMap){
        int safeArea = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
