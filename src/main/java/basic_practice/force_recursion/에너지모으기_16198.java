package basic_practice.force_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에너지모으기_16198 {

    static int N, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rec(1, 0);
        System.out.println(max);
    }

    static void rec(int depth, int sum) {
        if(depth == N - 1){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 1; i < N-1; i++){
            if (arr[i] == 0) continue;
            int temp = arr[i];
            int leftIdx = -1;
            int rightIdx = 1;
            while(arr[i+leftIdx] == 0){
                leftIdx--;
            }
            while(arr[i+rightIdx] == 0){
                rightIdx++;
            }
            sum += arr[i+leftIdx] * arr[i+rightIdx];
            arr[i] = 0;
            rec(depth + 1, sum);
            sum -= arr[i+leftIdx] * arr[i+rightIdx];
            arr[i] = temp;
        }
    }
}
