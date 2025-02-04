package basic_practice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 전구와스위치_2138 {

    static int N;
    static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];

        String input = br.readLine();
        for(int i = 0; i < N; i++){
            arr1[i] = input.charAt(i) - '0';
        }

        input = br.readLine();
        for(int i = 0; i < N; i++){
            arr2[i] = input.charAt(i) - '0';
        }

        int answer1 = solve(arr1.clone(), false);
        int answer2 = solve(arr1.clone(), true);

        if (answer1 == -1 && answer2 == -1) {
            System.out.println(-1);
        } else if (answer1 == -1) {
            System.out.println(answer2);
        } else if (answer2 == -1) {
            System.out.println(answer1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }
    }

    static int solve(int[] current, boolean firstSwitch) {
        int cnt = 0;
        if (firstSwitch) {
            switchLight(0, current);
            cnt++;
        }

        for(int i = 1; i < N; i++){
            if(current[i-1] != arr2[i-1]){
                switchLight(i, current);
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (current[i] != arr2[i]) {
                return -1;
            }
        }
        return cnt;
    }

    static void switchLight(int idx, int[] current){
        for(int i = idx-1; i <= idx+1; i++){
            if(i < 0 || i >= N) continue;
            current[i] = 1 - current[i];
        }
    }
}