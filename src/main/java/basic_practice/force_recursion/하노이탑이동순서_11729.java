package basic_practice.force_recursion;

import java.util.Scanner;

public class 하노이탑이동순서_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        hanoi(1,2,3,N);
        System.out.println(sb);

    }

    public static void hanoi(int from, int use, int to, int N) {
        if (N == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(from, to, use, N - 1);
        sb.append(from + " " + to + "\n");
        hanoi(use, from, to, N - 1);

    }
}