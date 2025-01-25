package basic_practice.hash;

import java.util.HashMap;
import java.util.Scanner;

public class 수들의합_2501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        HashMap<Integer, Integer > prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int currentPrefixSum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            currentPrefixSum += A[i];

            if (prefixSumCount.containsKey(currentPrefixSum - K)) {
                result += prefixSumCount.get(currentPrefixSum - K);
            }
            prefixSumCount.put(currentPrefixSum, prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1);
        }

        System.out.println(result);
    }
}
