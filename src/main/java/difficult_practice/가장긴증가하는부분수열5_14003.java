package difficult_practice;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열5_14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        int[] trace = new int[N];

        dp[0] = arr[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            if (dp[len - 1] < arr[i]) {
                dp[len] = arr[i];
                trace[i] = len;
                len++;
            } else {
                int pos = Arrays.binarySearch(dp, 0, len, arr[i]);
                if (pos < 0) pos = -(pos + 1);
                dp[pos] = arr[i];
                trace[i] = pos;
            }
        }

        int[] lis = new int[len];
        int k = len - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i] == k) {
                lis[k--] = arr[i];
            }
        }

        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}