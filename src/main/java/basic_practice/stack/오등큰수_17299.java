package basic_practice.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오등큰수_17299 {

    static int N, idx;
    static int[] arr, ans, stack;
    static int[] F = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[N];
        stack = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) F[arr[i]]++;

        idx = -1;
        for (int i = N - 1; i >= 0; i--) {
            if(idx == -1){
                stack[++idx] = arr[i];
                ans[i] = -1;
                continue;
            }
            while (idx != -1 && F[arr[i]] >= F[stack[idx]]) {
                idx--;
                if (idx == -1) ans[i] = -1;
            }
            if(idx != -1 && F[arr[i]] < F[stack[idx]]) ans[i] = stack[idx];
            stack[++idx] = arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
