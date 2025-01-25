package basic_practice.dp;

import java.util.Scanner;

public class 계단수_1562 {
    static int n;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 1][10][1 << 10];


        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int mask = 0; mask < (1 << 10); mask++) {
                    if (j > 0) {
                        dp[i][j][mask | (1 << j)] = (dp[i][j][mask | (1 << j)] + dp[i - 1][j - 1][mask]) % 1_000_000_000;
                    }
                    if (j < 9) {
                        dp[i][j][mask | (1 << j)] = (dp[i][j][mask | (1 << j)] + dp[i - 1][j + 1][mask]) % 1_000_000_000;
                    }
                }
            }
        }

        int ans = 0;
        int fullMask = (1 << 10) - 1;

        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i][fullMask]) % 1_000_000_000;
        }
        System.out.println(ans);
    }
}
