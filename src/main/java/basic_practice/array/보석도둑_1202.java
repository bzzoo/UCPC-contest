package basic_practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑_1202 {

    static int N, K;
    static List<Things> things;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        things = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            things.add(new Things(m, v));
        }

        bags = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        Collections.sort(things);
        Arrays.sort(bags);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long totalValue = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            while (idx < N && things.get(idx).m <= bags[i]) {
                maxHeap.add(things.get(idx).v);
                idx++;
            }

            if (!maxHeap.isEmpty()) {
                totalValue += maxHeap.poll();
            }
        }
        System.out.println(totalValue);
    }


    static class Things implements Comparable<Things>{
        int m;
        int v;

        public Things(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Things o) {
            if (this.m == o.m) return o.v - v;
            return m - o.m;
        }
    }
}
