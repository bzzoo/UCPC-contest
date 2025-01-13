package basic.math;

import java.util.Scanner;

public class 최소공배수_1934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int gcd = gcd(a, b);
            System.out.println(a * b / gcd);
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
