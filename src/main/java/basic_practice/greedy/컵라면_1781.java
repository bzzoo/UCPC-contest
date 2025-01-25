package basic_practice.greedy;

import java.util.*;
import java.io.*;

public class 컵라면_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> assignments = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            assignments.add(new int[] {deadline, ramen});
        }

        assignments.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] assignment : assignments) {
            int deadline = assignment[0];
            int ramen = assignment[1];

            pq.offer(ramen);
            if (pq.size() > deadline) {
                pq.poll();
            }
        }

        int maxRamen = 0;
        while (!pq.isEmpty()) {
            maxRamen += pq.poll();
        }

        System.out.println(maxRamen);
    }
}
