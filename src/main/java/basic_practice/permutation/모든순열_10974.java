package basic_practice.permutation;

import java.util.Scanner;

public class 모든순열_10974 {

    static int N;
    static int[]arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        arr = new int[N];
        rec(0);
    }

    static void rec(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=N; i++){
            if(visited[i-1]) continue;
            visited[i-1] = true;
            arr[depth] = i;
            rec(depth+1);
            visited[i-1] = false;
        }
    }
}
