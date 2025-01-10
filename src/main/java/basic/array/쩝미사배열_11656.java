package basic.array;

import java.util.Scanner;

public class 쩝미사배열_11656 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] suffix = new String[input.length()];
        for(int i = 0; i<input.length(); i++){
            suffix[i] = input.substring(i);
        }
        for(int i = 0; i<suffix.length; i++){
            for(int j = i+1; j<suffix.length; j++){
                if(suffix[i].compareTo(suffix[j]) > 0){
                    String temp = suffix[i];
                    suffix[i] = suffix[j];
                    suffix[j] = temp;
                }
            }
        }
        for(String s : suffix){
            System.out.println(s);
        }
    }

}
