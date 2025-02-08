package basic_practice.greedy;

import java.util.Scanner;

public class A와B_12904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        StringBuilder tempB = new StringBuilder(B);

        while (tempB.length() > A.length()) {
            if (tempB.charAt(tempB.length() - 1) == 'B') {
                tempB.deleteCharAt(tempB.length() - 1);
                tempB.reverse();
            } else {
                tempB.deleteCharAt(tempB.length() - 1);
            }

        }

        if (tempB.toString().equals(A)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
