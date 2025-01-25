package basic_practice.hash;

import java.util.HashMap;
import java.util.Scanner;

public class 두배열의합_2143 {

    static int T, n, m;
    static int[] A, B;
    static long result = 0;
    static HashMap<Long, Integer> mapA = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        n = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        m = sc.nextInt();
        B = new int[m];
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long sum = A[i];
            for (int j = i; j < n; j++) {
                if (i != j) sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }


        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++){
                sum += B[j];
                if(mapA.containsKey(T-sum)){
                    result += mapA.get(T-sum);
                }
            }
        }

        System.out.println(result);
    }
}
