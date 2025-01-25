package basic_practice.dp;

import java.io.*;
import java.util.StringTokenizer;

public class 카드구매하기2_16194 {

    static int[] dp, cards;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        cards = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //rec(0,0);
        System.out.println(rec2(N));
    }

    static int result = Integer.MAX_VALUE;
    static void rec(int sum, int price){
        if(sum == N) {
            result = Math.min(result, price);
            return;
        }
        if(sum > N) return;
        for(int i = 1; i <= N; i++){
            rec(sum + i, price + cards[i]);
        }
    }

    static int rec2(int sum){
        if(sum == 0) return 0;
        if(dp[sum] > 0) return dp[sum];
        dp[sum] = Integer.MAX_VALUE;
        for(int i = 1; i <= sum; i++){
            dp[sum] = Math.min(dp[sum], rec2(sum - i) + cards[i]);
        }

        return dp[sum];
    }
}
