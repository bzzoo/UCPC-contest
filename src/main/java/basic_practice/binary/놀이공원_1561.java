package basic_practice.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 놀이공원_1561 {

    static int N, M;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N <= M) {
            System.out.println(N);
            return;
        }

        st = new StringTokenizer(br.readLine());
        op = new int[M];

        int maxTime = -1;
        for (int i = 0; i < M; i++) {
            op[i] = Integer.parseInt(st.nextToken());
            maxTime = Math.max(maxTime, op[i]);
        }

        long left = 0;
        long right = (long) maxTime * N;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = M;

            for (int i = 0; i < M; i++) {
                count += mid / op[i];
            }

            if (count >= N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long time = left - 1;
        long total = M;

        for(int i = 0; i < M; i++){
            total += time / op[i];
        }

        total++;

        for(int i = 0; i < M; i++){
            if(left % op[i] == 0){
                if(total == N){
                    System.out.println(i+1);
                    return;
                }
            }
            total++;
        }
    }
}