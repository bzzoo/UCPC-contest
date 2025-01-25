package programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 도넛과막대그래프 {
    static List<Integer>[] gp;
    static HashMap<Integer, Integer> indegree;
    static HashMap<Integer, Integer> outdegree;

    public int[] solution(int[][] e) {
        int[] answer = {0, 0, 0, 0};
        gp = new List[1000001];

        indegree = new HashMap<>();
        outdegree = new HashMap<>();
        for (int i = 0; i <= 1000000; i++) {
            gp[i] = new ArrayList<>();
        }
        for (int i = 0; i < e.length; i++) {
            int src = e[i][0];
            int dist = e[i][1];
            gp[src].add(dist);
            indegree.put(dist, indegree.getOrDefault(dist, 0) + 1);
            outdegree.put(src, outdegree.getOrDefault(src, 0) + 1);
        }

        for (Integer key : outdegree.keySet()) {
            if (outdegree.get(key) >= 2 && !indegree.containsKey(key)) {
                answer[0] = key;

            } else if (outdegree.get(key) >= 2 && indegree.containsKey(key)) {
                answer[3]++;
            }
        }

        for (int node : indegree.keySet()) {
            if (!outdegree.containsKey(node)) {
                answer[2]++;
            }
        }

        answer[1] = outdegree.get(answer[0]) - answer[3] - answer[2];
        return answer;
    }
}

