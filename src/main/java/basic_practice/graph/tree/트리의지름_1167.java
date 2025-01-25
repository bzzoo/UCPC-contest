package basic_practice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1167 {

    static int V;
    static List<Edge>[] edges;
    static int max, far;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        edges = new List[V + 1];
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= V; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                int dist = Integer.parseInt(st.nextToken());
                if(dist == -1 ) break;
                int cost = Integer.parseInt(st.nextToken());
                edges[num].add(new Edge(dist, cost));
            }
        }
        visited = new boolean[V + 1];
        func(1,0);

        visited = new boolean[V + 1];
        func(far,0);
        System.out.println(max);
    }

    public static void func(int v, int depth){
        if(depth > max){
            max = depth;
            far = v;
        }
        visited[v] = true;
        for(Edge edge : edges[v]){
            if(visited[edge.dist]) continue;
            func(edge.dist, edge.cost + depth);
        }

    }

    public static class Edge implements Comparable<Edge> {
        int dist, cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
