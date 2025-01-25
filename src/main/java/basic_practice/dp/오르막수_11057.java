package basic_practice.dp;

import java.util.Scanner;

public class 오르막수_11057 {

    static int N, MOD = 10_007;
    static int[][] dp = new int[1001][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        rec(0, 0);
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[0][i];
        }
        System.out.println(sum % MOD);
    }

    static int rec(int depth, int num){
        if(depth == N) return 1;
        if(dp[depth][num] != 0) return dp[depth][num];
        for(int i = num; i < 10; i++){
            dp[depth][num] +=  (rec(depth + 1, i)) % MOD;
        }
        return dp[depth][num];
    }
}
