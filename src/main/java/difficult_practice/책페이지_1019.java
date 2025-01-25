package difficult_practice;

import java.io.*;

public class 책페이지_1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[10];
        int start = 1;
        int end = N;
        int digit = 1;

        while(start <= end){
            while(start % 10 != 0 && start <= end){
                calc(start, cnt, digit);
                start++;
            }

            if(start > end) break;

            while(end % 10 != 9 && start <= end){
                calc(end, cnt, digit);
                end--;
            }

            start /= 10;
            end /= 10;

            for(int i = 0; i < 10; i++){
                cnt[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }

        for(int i = 0; i < 10; i++){
            System.out.print(cnt[i] + " ");
        }
    }

    static void calc(int n, int[] cnt, int digit){
        while(n > 0){
            cnt[n % 10] += digit;
            n /= 10;
        }
    }
}