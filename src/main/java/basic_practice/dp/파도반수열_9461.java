package basic_practice.dp;

import java.util.Scanner;

public class 파도반수열_9461 {
    static int T;
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new long[101];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 3;
        T = sc.nextInt();

        for(int i = 6; i< 101; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }
        while(T-->0){
            int n = sc.nextInt();
            System.out.println(arr[n-1]);
        }
    }
}
