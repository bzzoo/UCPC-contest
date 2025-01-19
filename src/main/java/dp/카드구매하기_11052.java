package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기_11052 {

    static int N;
    static int[] cards, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(rec(0));
    }

    static int rec(int num) {
        if (num == N) return 0;
        if(num > N) return -100000;
        if(dp[num] != -1) return dp[num];
        for(int i = 1; i <= N; i++){
            dp[num] = Math.max(dp[num], rec(num + i)+ cards[i]);
        }
        return dp[num];
    }
}
