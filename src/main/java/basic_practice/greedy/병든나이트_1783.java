package basic_practice.greedy;

import java.util.Scanner;

public class 병든나이트_1783 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        int result;

        if (N == 1) {

            result = 1;
        } else if (N == 2) {

            result = Math.min(4, (M + 1) / 2);
        } else if (M < 7) {
            result = Math.min(4, M);
        } else {
            result = M - 2;
        }

        System.out.println(result);
    }
}
