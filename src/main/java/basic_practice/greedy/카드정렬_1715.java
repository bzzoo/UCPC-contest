package basic_practice.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드정렬_1715 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        if(pq.size() == 1){
            System.out.println(0);
            return;
        }
        while(pq.size() > 1){
            Integer one = pq.poll();
            Integer two = pq.poll();
            pq.add(one+two);
            answer+= one+two;
        }
        System.out.println(answer);
    }
}
