package basic_practice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_1080 {

    static int N,M;
    static int[][] map1, map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new int[N][M];
        map2 = new int[N][M];

        for(int i = 0; i < N ; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map1[i][j] = input.charAt(j) -'0';
            }
        }


        for(int i = 0; i < N ; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map2[i][j] = input.charAt(j) -'0';
            }
        }

        if(N < 3 || M < 3){
            if (same()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int cnt = 0;
        if(same()) {
            System.out.println(cnt);
            return;
        }
        for(int i = 0; i < N -2; i++) {
            for (int j = 0; j < M-2; j++) {
                if (map1[i][j] != map2[i][j]){
                    flip(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(same() ? cnt : -1);
    }

    static boolean same(){
        boolean flag = true;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map1[i][j] != map2[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    static void flip(int r, int c){
        for(int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if(map1[i][j] == 0) map1[i][j] = 1;
                else map1[i][j] = 0;
            }
        }
    }
}
