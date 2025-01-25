package basic_practice.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

    static int V, E, K;
    static List<Edge>[] list;
    static int[] cost;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        list = new List[V + 1];
        cost = new int[V + 1];
        for(int i = 1; i <= V; i++){
            cost[i] = INF;
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[src].add(new Edge(dist, c));
        }
        func(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++){
            if(cost[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(cost[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void func(int K) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> { return  o1.cost - o2.cost;}
        );

        cost[K] = 0;
        pq.add(new Edge(K, 0));
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            for(Edge next : list[now.dist]){
                if(cost[next.dist] > now.cost + next.cost){
                    cost[next.dist] = now.cost + next.cost;
                    pq.add(new Edge(next.dist, cost[next.dist]));
                }
            }
        }
    }

    static class Edge {
        int dist;
        int cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }
}
