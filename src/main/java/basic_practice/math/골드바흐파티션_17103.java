package basic_practice.math;

import java.util.Scanner;

public class 골드바흐파티션_17103 {

    static boolean[] prime = new boolean[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        prime[0] = prime[1] = true;
        getPrime();
        while(T-- > 0){
            int n = sc.nextInt();
            int cnt = 0;

            for(int i = 2; i <= n / 2; i++){
                if(!prime[i] && !prime[n - i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static public void getPrime(){
        for(int i = 0; i < Math.sqrt(1_000_000); i++){
            if (prime[i]) continue;
            for(int j = i * i; j <= 1_000_000; j += i){
                prime[j] = true;
            }
        }
    }
}
