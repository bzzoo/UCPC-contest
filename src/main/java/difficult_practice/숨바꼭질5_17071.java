package difficult_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질5_17071 {
    static boolean[][] visited = new boolean[500_001][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N][0] = true;

        int t = 0;
        int k = K;
        while (!q.isEmpty()) {
            t++;
            int mod = t % 2;
            int qSize = q.size(); //초 확장

            k += t;
            if (k > 500_000) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < qSize; i++) {
                int now = q.poll();

                if (now + 1 <= 500_000 && !visited[now + 1][mod]) {
                    q.add(now + 1);
                    visited[now + 1][mod] = true;
                }

                if (now - 1 >= 0 && !visited[now - 1][mod]) {
                    q.add(now - 1);
                    visited[now - 1][mod] = true;
                }

                if (now * 2 <= 500_000 && !visited[now * 2][mod]) {
                    q.add(now * 2);
                    visited[now * 2][mod] = true;
                }
            }

            if (visited[k][mod]) {
                System.out.println(t);
                return;
            }
        }
        System.out.println(-1);
    }
}
