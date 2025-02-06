package basic_practice.greedy;

import java.util.Scanner;

public class 잃어버린괄호_1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] minusSplit = input.split("-");

        int result = sum(minusSplit[0]);
        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]);
        }

        System.out.println(result);
        sc.close();
    }

    static int sum(String expression) {
        int sum = 0;
        for (String num : expression.split("\\+")) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}