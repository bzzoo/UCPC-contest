package basic_practice.graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 도시분할계획_1647 {

    static int N, M;
    static ArrayList<int[]> map;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new int[N+1];
        map = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            root[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());
            map.add(input);
        }
        Collections.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int minSum = func();
        System.out.println(minSum - maxLoad);
    }

    static int maxLoad = Integer.MIN_VALUE;
    public static int func() {
        int sum = 0;
        int cnt = 0;
        for (int[] edge : map) {
            if(union(edge[0], edge[1])){
                sum += edge[2];
                if(maxLoad < edge[2]) maxLoad = edge[2];
                if(++cnt == N - 1) return sum;
            }
        }
        return sum;
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        root[a] = b;
        return true;
    }

    public static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
