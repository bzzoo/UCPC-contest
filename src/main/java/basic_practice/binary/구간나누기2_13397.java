package basic_practice.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간나누기2_13397 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max-min;

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (determine(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean determine(int d) {
        int seg = 1;
        int segMax = arr[0];
        int segMin = arr[0];

        for(int i = 1; i< N; i++){
            segMax = Math.max(segMax, arr[i]);
            segMin = Math.min(segMin, arr[i]);

            if(segMax - segMin > d){
                seg++;
                segMin = arr[i];
                segMax = arr[i];
            }

            if(seg > M){
                return false;
            }
        }

       return seg == M;
    }
}
