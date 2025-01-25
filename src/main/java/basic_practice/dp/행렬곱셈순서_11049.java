package basic_practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 행렬곱셈순서_11049 {
    static int N;
    static int[][] mat;
    static int[][] dp;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        mat = new int[N][2];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            mat[i] = new int[]{r, c};
        }

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], INF);

        System.out.println(func(0, N - 1));
    }

    private static int func(int s, int e) {
        if(s == e) return 0;
        if (dp[s][e] != INF) return dp[s][e];
        for (int i = s; i < e; i++) {
            dp[s][e] = Math.min(func(s, i) + func(i + 1, e) + mat[s][0] * mat[i][1] * mat[e][1], dp[s][e]);
        }
        return dp[s][e];
    }
}
