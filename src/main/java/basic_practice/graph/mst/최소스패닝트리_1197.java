package basic_practice.graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197 {

    static int V, E;
    static ArrayList<Edge> edges;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new int[V + 1];
        edges = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            root[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }
        Collections.sort(edges);
        System.out.println(func());
    }

    public static int func(){
        int sum = 0;
        int cnt = 0;
        for(Edge edge : edges){
            if(union(edge.from, edge.to)){
                sum += edge.cost;
                if(++cnt == V -1) return sum;
            }
        }
        return sum;
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        root[a] = b;
        return true;
    }

    private static int find(int a) {
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    public static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
