package basic_practice.math;

import java.util.Scanner;

public class 골드바흐의추측_6588 {

    static boolean[] sosu = new boolean[1_000_001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sosu[0] = sosu[1] = true;

        for(int i = 2; i<=Math.sqrt(1_000_000); i++){
            if(sosu[i]) continue;
            for(int j = i*i; j<=1_000_000; j+=i){
                sosu[j] = true;
            }
        }

        while(true){
            int n = sc.nextInt();
            if(n == 0) break;

            boolean flag = false;
            for(int i = 3; i<=n/2; i+=2){
                if(!sosu[i] && !sosu[n-i]){
                    System.out.println(n + " = " + i + " + " + (n-i));
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

}
