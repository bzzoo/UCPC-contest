package basic_practice.dp;

import java.util.Scanner;

public class 파일합치기_11066 {
    static int T;
    static int[][] dp, ps;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            arr = new int[n];
            dp = new int[n][n];
            ps = new int[n][n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                ps[i][i] = arr[i];
                for (int j = i + 1; j < n; j++) {
                    ps[i][j] = ps[i][j - 1] + arr[j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println(func(0, n - 1));
        }
    }

    private static int func(int s, int e) {
        if (s == e) return 0;
        if(dp[s][e] != Integer.MAX_VALUE) return dp[s][e];

        for(int i = s; i < e; i++){
            dp[s][e] = Math.min(func(s, i) + func(i+1, e) + ps[s][e], dp[s][e]);
        }
        return dp[s][e];
    }
}
