package basic_practice.graph.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 집합의표현_1717 {

    static int N, M;
    static ArrayList<int[]> set;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());
            set.add(input);
        }
        for(int[] item : set){
            if(item[0] == 0){
                union(item[2], item[1]);
                continue;
            }
            if(item[0] == 1){
                int a = find(item[1]);
                int b = find(item[2]);
                if(a==b) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return false;
        parent[a] = b;
        return true;
    }

    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
