package basic_practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 삼십_10610 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int[] arr = new int[input.length()];

        boolean zero = false;
        for(int i = 0; i < arr.length; i++){
            int num =  input.charAt(i) - '0';
            if(num == 0) zero = true;
            arr[i] = num;
        }

        if(!zero) {
            System.out.println(-1);
            return;
        }
        else {
            int checkSum = 0;
            for(int i = 0; i < arr.length; i++){
                checkSum += arr[i];
            }

            if(checkSum % 3 != 0){
                System.out.println(-1);
                return;
            }
            Arrays.sort(arr);
            for(int i = arr.length-1; i >= 0; i--){
                System.out.print(arr[i]);
            }
        }
    }

}
