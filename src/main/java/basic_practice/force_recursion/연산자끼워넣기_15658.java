package basic_practice.force_recursion;

import java.util.Scanner;

public class 연산자끼워넣기_15658 {

    static int N;
    static int[] op;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        func(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void func(int depth, int sum){
        if(depth == N){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;
                if(i == 0) func(depth + 1, sum + nums[depth]);
                else if (i == 1)  func(depth + 1, sum - nums[depth]);
                else if (i == 2)  func(depth + 1, sum * nums[depth]);
                else func(depth + 1, sum / nums[depth]);
                op[i]++;
            }
        }
    }
}
