package basic_practice.dp;

import java.util.Scanner;

public class 제곱수의합_1699 {

    static int N, result;
    static int[] dp = new int[100_001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= N; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
