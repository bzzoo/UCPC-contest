package basic_practice.force;

import java.util.Scanner;

public class 카잉달력_6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int result = -1;

            while (x <= M * N) {
                if ((x - y) % N == 0) {
                    result = x;
                    break;
                }
                x += M;
            }
            System.out.println(result);
        }
    }
}
