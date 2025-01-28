package basic_practice.permutation;

import java.util.Scanner;

public class 단어수학_1339 {
    static int N, result;
    static String[] words;
    static int[] weight = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new String[N];

        for(int i = 0; i < N; i++) {
            String word = sc.next();
            words[i] = word;
            int pow = 1;
            for(int j = word.length()-1; j >= 0; j--) {
                weight[word.charAt(j) - 'A'] += pow;
                pow *= 10;
            }
        }

        int result = 0;
        int num = 9;
        while(true) {
            int max = 0;
            int idx = -1;
            for(int i = 0; i < 26; i++) {
                if(weight[i] > max) {
                    max = weight[i];
                    idx = i;
                }
            }
            if(idx == -1) break;
            result += weight[idx] * num--;
            weight[idx] = 0;
        }

        System.out.println(result);
    }
}