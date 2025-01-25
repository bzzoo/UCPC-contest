package basic_practice.dp;

import java.util.Scanner;

public class M암호코드_2011 {
    static char[] nums;
    static int[] dp;
    static int MOD = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nums = sc.next().toCharArray();
        dp = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i] = -1;
        System.out.println(func(0));
    }

    private static int func(int idx) {
        if (idx == nums.length) return 1;
        if (dp[idx] != -1) return dp[idx];

        int count = 0;
        if (nums[idx] != '0') {
            count = (count + func(idx + 1)) % MOD;
        }
        if (idx < nums.length - 1) {
            int combinedNumber = (nums[idx] - '0') * 10 + (nums[idx + 1] - '0');
            if (combinedNumber >= 10 && combinedNumber <= 26)
                count = (count + func(idx + 2)) % MOD;
        }
        dp[idx] = count % MOD;
        return dp[idx];
    }
}
