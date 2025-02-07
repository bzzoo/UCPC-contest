package basic_practice.greedy;

import java.util.*;
import java.io.*;

public class 수묶기_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            } else {
                hasZero = true;
            }
        }


        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());

        long sum = 0;

        for (int i = 0; i < negative.size() - 1; i += 2) {
            sum += (long)negative.get(i) * negative.get(i + 1);
        }

        if (negative.size() % 2 == 1) {
            if (!hasZero) {
                sum += negative.get(negative.size() - 1);
            }
        }

        for (int i = 0; i < positive.size() - 1; i += 2) {
            if (positive.get(i) * positive.get(i + 1) > positive.get(i) + positive.get(i + 1)) {
                sum += (long)positive.get(i) * positive.get(i + 1);
            } else {
                sum += positive.get(i) + positive.get(i + 1);
            }
        }

        if (positive.size() % 2 == 1) {
            sum += positive.get(positive.size() - 1);
        }

        System.out.println(sum);
    }
}