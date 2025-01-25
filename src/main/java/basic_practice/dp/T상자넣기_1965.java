package basic_practice.dp;

import java.util.Scanner;

public class T상자넣기_1965 {

    static int n;
    static int[] box;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        box = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            box[i] = sc.nextInt();
            dp[i] = 1;
        }
        dp[0] = 1;

        for(int i = 1; i<= n; i++){
            for(int j = 1; j < i; j++){
                if(box[i] > box[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
