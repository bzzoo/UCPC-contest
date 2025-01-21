package basic.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(st.nextToken());
        }

        long maxSum = Long.MIN_VALUE;
        long minPrefix = 0;

        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefixSum[i]);
        }

        System.out.println(maxSum);
    }
}
