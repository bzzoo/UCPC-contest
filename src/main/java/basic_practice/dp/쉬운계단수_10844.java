package basic_practice.dp;

import java.util.Scanner;

public class 쉬운계단수_10844 {

    static int N, DIVIDER = 1_000_000_000;
    static int[][] dp = new int[101][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][1] % DIVIDER;
                } else if(j == 9){
                    dp[i][j] = dp[i - 1][8] % DIVIDER;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIVIDER;
                }
            }
        }

        int result = 0;
        for(int i = 0; i <= 9; i++){
            result = (result + dp[N][i]) % DIVIDER;
        }
        System.out.println(result);
    }
}
