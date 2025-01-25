package basic_practice.force;

import java.util.Scanner;

public class 날짜계산_1476 {

    static int E, S, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        int e = 1, s = 1, m = 1;
        int year = 1;
        while(true){
            if(e == E && s == S && m == M){
                System.out.println(year);
                break;
            }
            e++;
            s++;
            m++;
            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
            year++;
        }
    }
}
