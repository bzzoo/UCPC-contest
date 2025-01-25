package programmers.Level3;
import java.util.*;
public class 주사위고르기 {
    class Solution {
        static boolean[] visited;
        static int[] answer;
        static int[] a,b;
        static int[][] copy;
        static TreeMap<Integer, Integer> A, B;
        static int N, M;
        public int[] solution(int[][] dice) {
            N = dice.length;
            M = dice[0].length;
            answer = new int[N/2];
            visited = new boolean[N];
            copy = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j< M; j++){
                    copy[i][j] = dice[i][j];
                }
            }
            a = new int[N/2];
            b = new int[N/2];
            select(0, 0);
            return answer;

        }
        static int max = Integer.MIN_VALUE;
        static void select(int depth, int idx){
            if(depth == N /2){
                A = new TreeMap<>();
                B = new TreeMap<>();
                int aIndex = 0;
                int bIndex = 0;
                for (int i = 0; i < N; i++) {
                    if (visited[i]) {
                        a[aIndex++] = i;
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        b[bIndex++] = i;
                    }
                }

                calculateAllSumsRecursive(a, 0, 0, A);
                calculateAllSumsRecursive(b, 0, 0, B);

                int winCount = 0;
                for (Map.Entry<Integer, Integer> entryA : A.entrySet()) {
                    int sumA = entryA.getKey();
                    int countA = entryA.getValue();
                    for (Map.Entry<Integer, Integer> entryB : B.entrySet()) {
                        int sumB = entryB.getKey();
                        int countB = entryB.getValue();
                        if (sumA > sumB) {
                            winCount += countA * countB;
                        }
                    }
                }

                if (winCount > max) {
                    max = winCount;
                    for (int i = 0; i < N / 2; i++) {
                        answer[i] = a[i] + 1;
                    }
                }
                return;
            }
            for(int i = idx; i < N; i++){
                if(!visited[i]){
                    visited[i] = true;
                    select(depth+1, i);
                    visited[i] = false;
                }
            }
        }

        static void calculateAllSumsRecursive(int[] indices, int currentIndex, int currentSum, TreeMap<Integer, Integer> map) {
            if (currentIndex == indices.length) {
                map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
                return;
            }


            int diceIndex = indices[currentIndex];


            for (int face = 0; face < copy[0].length; face++) {
                int newSum = currentSum + copy[diceIndex][face];
                calculateAllSumsRecursive(indices, currentIndex + 1, newSum, map);
            }
        }
    }
}
