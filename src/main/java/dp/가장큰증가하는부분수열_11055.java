package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열_11055 {

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}