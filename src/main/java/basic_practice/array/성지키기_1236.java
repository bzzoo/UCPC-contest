package basic_practice.array;

import java.util.Scanner;

public class 성지키기_1236 {
    static int N, M;
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        for(int i = 0; i<N; i++) map[i] = sc.next().toCharArray();

        int rowCnt = 0;
        int colCnt = 0;
        for(int i = 0; i < N; i++){
            boolean ok = false;
            for(int j = 0; j < M; j++){
                if(map[i][j] =='X'){
                    ok = true;
                    break;
                }
            }
            if(ok) rowCnt++;
        }
        for(int i = 0; i < M; i++){
            boolean ok = false;
            for(int j = 0; j < N; j++){
                if(map[j][i] =='X'){
                    ok = true;
                    break;
                }
            }
            if(ok) colCnt++;
        }
        int max = Math.max(N - rowCnt, M - colCnt);
        System.out.println(max);
    }
}
