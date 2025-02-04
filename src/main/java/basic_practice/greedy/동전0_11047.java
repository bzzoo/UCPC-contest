package basic_practice.greedy;

import java.util.Scanner;

public class 동전0_11047 {

    static int N, K, result;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        while (K > 0) {

            int idx = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(arr[i] <= K){
                    idx = i;
                    break;
                }
            }
            K -= arr[idx];
            result++;
        }
        System.out.println(result);
    }
}
