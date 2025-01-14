package basic.math;

import java.util.Scanner;

public class 조합0의개수_2004 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();


        long five = five(n) - five(n - m) - five(m);
        long two = two(n) - two(n - m) - two(m);

        System.out.println(Math.min(five, two));

    }

    public static long five(long n) {
        long count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static long two(long n) {
        long count = 0;
        for (long i = 2; i <= n; i *= 2) {
            count += n / i;
        }
        return count;
    }
}
