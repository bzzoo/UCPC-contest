package basic_practice.graph.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 돌그룹_12886 {

    static int[] arr = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(func());
    }

    static int func() {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(arr);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == cur[1] && cur[1] == cur[2]) {
                return 1;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    int[] next = move(cur, i, j);
                    if (next != null) {
                        String key = arrayToString(next);
                        if (!visited.contains(key)) {
                            visited.add(key);
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    static String arrayToString(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return Arrays.toString(sorted);
    }
    static int[] move(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return null;

        int[] next = arr.clone();
        int x = Math.min(arr[i], arr[j]);
        int y = Math.max(arr[i], arr[j]);

        next[i] = arr[i] == x ? x * 2 : y - x;
        next[j] = arr[j] == x ? x * 2 : y - x;

        return next;
    }
}
