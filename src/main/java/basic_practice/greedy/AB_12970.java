package basic_practice.greedy;

import java.util.Arrays;
import java.util.Scanner;
public class AB_12970 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (K > (N/2) * ((N+1)/2)) {
            System.out.println(-1);
            return;
        }

        if (K == 0) {
            System.out.println("B".repeat(N));
            return;
        }

        for (int numA = 1; numA <= N; numA++) {
            int numB = N - numA;
            int maxPairs = numA * numB;

            if (maxPairs >= K) {
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < numA; i++) {
                    result.append('A');
                }

                for (int i = 0; i < numB; i++) {
                    result.append('B');
                }

                int diff = maxPairs - K;
                if (diff > 0) {
                    char[] arr = result.toString().toCharArray();
                    for (int i = numA - 1; i < numA - 1 + diff; i++) {
                        char temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                    System.out.println(new String(arr));
                } else {
                    System.out.println(result);
                }
                return;
            }
        }

        System.out.println(-1);
    }
}