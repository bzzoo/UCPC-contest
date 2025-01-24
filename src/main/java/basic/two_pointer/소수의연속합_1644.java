package basic.two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수의연속합_1644 {

    public static ArrayList<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        ArrayList<Integer> primes = getPrimes(N);
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (true) {
            if (sum >= N) {
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }

            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
