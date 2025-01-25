package basic_practice.dp;

import java.util.Scanner;

public class T타일채우기_2133 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[N + 1];
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2;
            for (int j = i - 2; j >= 4; j -= 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}