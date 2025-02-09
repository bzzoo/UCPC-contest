package basic_practice.binary;

import java.util.Scanner;

public class 수이어쓰기2_1790 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (getLength(N) < K) {
            System.out.println(-1);
            return;
        }

        int left = 1, right = N;
        int targetNum = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            long length = getLength(mid);

            if (length < K) {
                left = mid + 1;
            } else {
                targetNum = mid;
                right = mid - 1;
            }
        }


        if (targetNum > N) {
            System.out.println(-1);
            return;
        }

        long prevLength = getLength(targetNum - 1);
        String targetStr = Integer.toString(targetNum);
        int index = (int) (K - prevLength - 1);

        System.out.println(targetStr.charAt(index));
    }

    static long getLength(int num) {
        long length = 0;
        int digit = 1;
        long start = 1;

        while (start <= num) {
            long end = Math.min(num, start * 10 - 1);
            length += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }

        return length;
    }
}
