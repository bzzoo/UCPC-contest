package basic.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 재활용캠페인_22988 {

    static int N;
    static long X;
    static long[] C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        X = Long.parseLong(input[1]);

        C = new long[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(C);

        int l = 0, r = N-1;
        int halfCnt = 0, remain = 0;
        while(l <= r){
            if(C[r] >= X){
                r--;
                halfCnt++;
                continue;
            }
            if(r == l) {
                remain++;
                break;
            }
            if(C[r] + C[l] >= X / 2.0){
                r--;
                l++;
                halfCnt++;
            } else {
                l++;
                remain++;
            }
        }
        System.out.println(halfCnt + (remain / 3));
    }
}
