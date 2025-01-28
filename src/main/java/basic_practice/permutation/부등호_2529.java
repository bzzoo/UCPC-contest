package basic_practice.permutation;

import java.math.BigInteger;
import java.util.Scanner;

public class 부등호_2529 {

    static int k;
    static boolean[] visited;
    static int[] arr;
    static char[] op;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        visited = new boolean[10];
        arr = new int[k + 1];
        op = new char[k];

        for (int i = 0; i < k; i++) {
            op[i] = sc.next().charAt(0);
        }

        rec(0);
        String maxStr = String.valueOf(max);
        String minStr = String.valueOf(min);
        if(minStr.length() < k+1) {
            minStr = "0" + minStr;
        }
        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static BigInteger max = BigInteger.ZERO;
    static BigInteger min = new BigInteger("9999999999");

    static void rec(int depth) {
        if (depth == k + 1) {
            if(check()){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < k + 1; i++) {
                    sb.append(arr[i]);
                }
                BigInteger num = new BigInteger(sb.toString());
                max = max.max(num);
                min = min.min(num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i;
            rec(depth + 1);
            visited[i] = false;
            arr[depth] = 0;
        }
    }

    static boolean check(){
        for(int i = 0; i < k; i++){
            if(op[i] == '<' && arr[i] > arr[i + 1]){
                return false;
            }
            if(op[i] == '>' && arr[i] < arr[i + 1]){
                return false;
            }
        }
        return true;
    }
}
