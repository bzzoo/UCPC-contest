package basic_practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 도서관_1461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i += m) {
            if (arr[i] < 0) {
                answer += Math.abs(arr[i]) * 2;
            } else break;
        }

        for (int i = n - 1; i >= 0; i -= m) {
            if (arr[i] > 0) {
                answer += arr[i] * 2;
            } else break;
        }

        answer -= Math.max(Math.abs(arr[0]), Math.abs(arr[n - 1]));
        System.out.println(answer);
    }
}
