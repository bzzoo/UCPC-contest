package basic_practice.force;

import java.util.Scanner;

public class 수이어쓰기1_1748 {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int result = 0;
        int len = 0;

        int n = N;
        while (true){
            n = n /10;
            len++;
            if(n == 0){
                break;
            }
        }

        for (int i = 1; i < len; i++) {
            result += (int) (9 * Math.pow(10, i - 1) * i);
        }
        result += (int) ((Math.abs(Math.pow(10, len-1) - N)) + 1) *(len);

        System.out.println(result);
    }
}
