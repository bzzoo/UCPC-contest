package basic_practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LIS4_14002 {

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        Deque<Integer> deque = new LinkedList<>();
        for (int i = N; i >= 1; i--) {
            if (dp[i] == max) {
                deque.addFirst(arr[i]);
                max--;
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
