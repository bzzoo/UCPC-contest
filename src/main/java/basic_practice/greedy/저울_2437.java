package basic_practice.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class 저울_2437 {
    static int n;
    static int[] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static TreeSet<Integer> tr = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int minMissing = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > minMissing) break;
            minMissing += arr[i];
        }

        System.out.println(minMissing);
    }
}
