package basic_practice.math;

import java.util.Scanner;

public class 숨바꼭질6_17087 {

    static int N, S, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(S - sc.nextInt());
        }

        D = arr[0];
        for (int i = 1; i < N; i++) {
            D = gcd(D, arr[i]);
        }
        System.out.println(D);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
