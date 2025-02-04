package basic_practice.greedy;

import java.io.*;
import java.util.*;

public class 순회강연_2109 {

    static int n;
    static List<int[]> lesson;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lesson = new ArrayList<>();
        int maxDay = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lesson.add(new int[]{pay, day});
            maxDay = Math.max(maxDay, day);
        }

        Collections.sort(lesson, (a, b) -> b[0] - a[0]);

        boolean[] visited = new boolean[maxDay + 1];
        int answer = 0;

        for(int[] cur : lesson) {
            int day = cur[1];
            while(day > 0) {
                if(!visited[day]) {
                    visited[day] = true;
                    answer += cur[0];
                    break;
                }
                day--;
            }
        }

        System.out.println(answer);
    }
}