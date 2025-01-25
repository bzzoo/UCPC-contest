package basic_practice.graph.dijkstra;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 해킹_10282 {

    static int T;
    static int n, d, c;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            d = sc.nextInt();
            c = sc.nextInt();

            List<Node>[] list = new List[n + 1];
            int[] cost = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<Node>();
                cost[i] = INF;
            }

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                list[b].add(new Node(a, s));
            }

            int[] result = func(c, cost, list);

            int virusCount = 0;
            int totalSeconds = 0;

            for (int i : result) {
                if (i != INF) {
                    virusCount += 1;
                    totalSeconds = Math.max(totalSeconds, i);
                }
            }
            System.out.println(virusCount + " " + totalSeconds);
        }
    }

    static int[] func(int start, int[] cost, List[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1.cost - o2.cost;
                }
        );
        cost[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Object node : list[now.dist]) {
                Node next = (Node) node;
                if(cost[next.dist] > now.cost + next.cost){
                    cost[next.dist] = now.cost + next.cost;
                    pq.add(new Node(next.dist, cost[next.dist]));
                }
            }
        }
        return cost;
    }

    static class Node {
        int dist;
        int cost;

        public Node(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }
}
