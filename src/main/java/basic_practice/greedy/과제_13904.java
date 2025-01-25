package basic_practice.greedy;

import java.util.*;

public class 과제_13904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Problem> ps = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int remainDays = sc.nextInt();
            int score = sc.nextInt();
            ps.add(new Problem(remainDays, score));
        }

        Collections.sort(ps, (a, b) -> {
            if (a.remainDays == b.remainDays) return b.score - a.score;
            return a.remainDays - b.remainDays;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for (Problem p : ps) {
            if (pq.size() < p.remainDays) {
                pq.offer(p.score);
                sum += p.score;
            } else if (!pq.isEmpty() && pq.peek() < p.score) {
                sum += p.score - pq.poll();
                pq.offer(p.score);
            }
        }

        System.out.println(sum);
    }

    static class Problem implements Comparable<Problem>{
        int remainDays;
        int score;

        public Problem(int remainDays, int score) {
            this.remainDays = remainDays;
            this.score = score;
        }

        @Override
        public int compareTo(Problem o) {
            if(remainDays == o.remainDays) return o.score - score;
            return remainDays - o.remainDays;
        }
    }
}
