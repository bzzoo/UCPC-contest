package basic.math;

import java.util.Scanner;

public class 소수구하기_1929 {

    static boolean[] sosu;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        sosu = new boolean[N + 1];

        sosu[0] = sosu[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (sosu[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                sosu[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!sosu[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
