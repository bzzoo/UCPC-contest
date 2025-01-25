package basic_practice.graph.basic;

import java.io.*;
import java.util.*;

public class 게리맨더링_17471 {

    static int N, result = Integer.MAX_VALUE;
    static int[] population;
    static List<Integer>[] adj;
    static int[] selected;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        population = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(input[i]);
        }
        visited = new boolean[N];
        selected = new int[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        combi(0, 0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void combi(int start, int firstArea, int secondArea) {
        if(firstArea == N|| secondArea == N) return;
        if(firstArea + secondArea == N){
            int sub = validAreaWithSubResult();
            result = Math.min(result, sub);
        }
        for(int i = start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[i] = 1;
                combi(i, firstArea+1, secondArea);
                selected[i] = 2;
                combi(i, firstArea, secondArea+1);
                selected[i] = 0;
                visited[i] = false;
            }
        }

    }

    public static int validAreaWithSubResult(){
        Queue<Integer> qf = new LinkedList<>();
        Queue<Integer> qs = new LinkedList<>();
        boolean[] visited = new boolean[N];

        int fSum = 0;
        int sSum = 0;
        for(int i = 0; i<N; i++){
            if(selected[i] == 1){
                qf.add(i);
                fSum += population[i];
                visited[i] = true;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if(selected[i] == 2){
                qs.add(i);
                sSum += population[i];
                visited[i] = true;
                break;
            }
        }

        while (!qf.isEmpty()) {
            int cur = qf.poll();
            for (int next : adj[cur]) {
                if (selected[next] == 1 && !visited[next]) {
                    qf.add(next);
                    fSum += population[next];
                    visited[next] = true;
                }
            }
        }

        while (!qs.isEmpty()) {
            int cur = qs.poll();
            for (int next : adj[cur]) {
                if (selected[next] == 2 && !visited[next]) {
                    qs.add(next);
                    sSum += population[next];
                    visited[next] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return Integer.MAX_VALUE;
            }
        }

        return Math.abs(fSum - sSum);
    }
}
