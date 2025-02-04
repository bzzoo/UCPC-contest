package basic_practice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기_1285 {

    static int N;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int bit = 0; bit < (1 << N); bit++) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if((bit & (1 << i)) != 0) {
                    for(int j = 0; j < N; j++) {
                        map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
                    }
                }
            }

            for(int j = 0; j < N; j++) {
                int cnt = 0;
                for(int i = 0; i < N; i++) {
                    if(map[i][j] == 'T') cnt++;
                }
                sum += Math.min(cnt, N-cnt);
            }
            answer = Math.min(answer, sum);

            for(int i = 0; i < N; i++) {
                if((bit & (1 << i)) != 0) {
                    for(int j = 0; j < N; j++) {
                        map[i][j] = map[i][j] == 'H' ? 'T' : 'H';
                    }
                }
            }
        }
        System.out.println(answer);
    }
}