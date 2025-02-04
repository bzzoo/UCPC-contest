package basic_practice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] prefix = new int[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result += prefix[i];
        }

        System.out.println(result);
    }

}
