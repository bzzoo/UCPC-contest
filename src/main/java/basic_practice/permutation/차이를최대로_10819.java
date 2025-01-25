package basic_practice.permutation;

import java.util.Scanner;

public class 차이를최대로_10819 {

    static int N;
    static int[] arr, memo;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        memo = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        rec(0);
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;
    static void rec(int depth){
        if(depth == N){
            int cal = cal();
            max = Math.max(cal, max);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            memo[depth] = arr[i];
            rec(depth + 1);
            memo[depth] = 0;
            visited[i] = false;
        }
    }

    static int cal(){
        int result = 0;
        for(int i = 0; i < N-1; i++){
            result += Math.abs(memo[i] - memo[i+1]);
        }

        return result;
    }
}
