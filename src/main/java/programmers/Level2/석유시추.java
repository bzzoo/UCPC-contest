package programmers.Level2;

import java.util.*;
public class 석유시추 {
    static HashMap<Integer,Integer> massAmount;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(int[][] land) {
        massAmount = new HashMap<>();
        numbering(land);
        landering(land);
        return max;
    }
    static int max = Integer.MIN_VALUE;
    static void landering(int[][] land){

        for(int i = 0; i < land[0].length; i++){
            int sum = 0;
            boolean[] visited = new boolean[massAmount.size() + 2];
            for(int j = 0; j <land.length; j++){
                if(land[j][i] != 0 && !visited[land[j][i]]){
                    sum += massAmount.get(land[j][i]);
                    visited[land[j][i]] = true;
                }
            }
            if(max < sum) max = sum;
        }
    }

    static public int numbering(int[][] land){
        int n = land.length;
        int m = land[0].length;

        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1){
                    num++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    land[i][j] = num;
                    massAmount.put(num, massAmount.getOrDefault(num, 0) + 1);
                    while(!q.isEmpty()){
                        int[] now = q.poll();

                        for(int k = 0; k < 4; k++){
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];
                            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                            if(land[nr][nc] != 1) continue;
                            land[nr][nc] = num;
                            massAmount.put(num, massAmount.getOrDefault(num, 0) + 1);
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
            }
        }
        return 0;
    }
}