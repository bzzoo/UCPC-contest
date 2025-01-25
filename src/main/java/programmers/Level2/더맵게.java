package programmers.Level2;

import java.util.PriorityQueue;
public class 더맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                pq.add(scoville[i]);
            }
            int count = 0;
            while (!pq.isEmpty()) {
                if (pq.peek() >= K) {
                    break;
                } else if (pq.peek() < K && pq.size() >= 2) {
                    int first = pq.poll();
                    int second = pq.poll();
                    pq.add(first + (second * 2));
                    count++;
                }
                if (pq.peek() < K && pq.size() < 2) {
                    count = -1;
                    break;
                }
            }
            return count;
        }
    }
}
