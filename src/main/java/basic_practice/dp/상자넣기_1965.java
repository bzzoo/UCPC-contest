package basic_practice.dp;

import java.util.Scanner;

public class 상자넣기_1965 {

    static int n;
    static int[] box;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        box = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) box[i] = sc.nextInt();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, func(i));
        }

        System.out.println(result);
    }
    private static int func(int depth) {
        if (dp[depth] != -1) return dp[depth];
        for (int i = depth + 1; i <= n; i++) {
            if (box[depth] < box[i]) {
                dp[depth] = Math.max(dp[depth], func(i) + 1);
            }
        }
        return dp[depth];
    }
}
