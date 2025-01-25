package basic.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이전순열_10973 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prevPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean prevPermutation(int[] arr) {
        int i = N - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = N - 1;
        while (arr[i - 1] <= arr[j]) {
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = N - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
