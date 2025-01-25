package basic_practice.dp;

import java.util.Scanner;

public class 계단오르기_2579 {

    static int count;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        nums = new int[count + 1];
        dp = new int[count + 1][3];
        for (int i = 1; i <= count; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i <= count; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(func(count, 0));
    }

    private static int func(int depth, int three) {
        if (depth <= 0) return 0;
        if (dp[depth][three] != -1) return dp[depth][three];
        if (three < 2) {
            dp[depth][three] = Math.max(func(depth - 1, three + 1), func(depth - 2, 0)) + nums[depth];
        }
        return dp[depth][three];
    }
}
