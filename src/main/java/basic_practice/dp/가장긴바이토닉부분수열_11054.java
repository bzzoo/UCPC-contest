package basic_practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;
        dp[0][1] = 1;
        int result = 0;
        for (int i = 1; i < N; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dp[i][1] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i][0] + dp[i][1] - 1);
        }
        System.out.println(result);
    }

}
