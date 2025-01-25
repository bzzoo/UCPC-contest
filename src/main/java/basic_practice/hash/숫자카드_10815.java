package basic_practice.hash;

import java.util.*;
import java.io.*;


public class 숫자카드_10815 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> cards = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cards.put(num, cards.getOrDefault(num , 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(cards.containsKey(num))
                System.out.print("1 ");
            else System.out.print("0 ");
        }
    }

}
