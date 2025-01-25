package basic_practice.prefix_sum;

import java.util.Scanner;

public class 나머지_10986 {
    static int N, M;
    static long[] ps, count, arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new long[N];
        ps = new long[N];
        count = new long[M];

        for(int i = 0; i < N; i++){
            int in = sc.nextInt();
            if(i ==0) ps[i] = in % M;
            if(i > 0) ps[i] = (ps[i-1] + in) % M;
            count[(int) ps[i]]++;
        }

        long answer = count[0];
        for(int i = 0; i < M; i++){
            answer +=  count[i] * (count[i]-1) / 2;
        }
        System.out.println(answer);
    }
}
