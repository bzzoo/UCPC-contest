package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3_17142 {

    static int N, M;
    static int[][] lab;
    static List<int[]> viruses;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    viruses.add(new int[]{i, j}); // 바이러스 위치 저장
                }
            }
        }

        chooseViruses(new ArrayList<>(), 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }


    static void chooseViruses(List<int[]> selected, int start) {
        if (selected.size() == M) {
            spread(selected);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            selected.add(viruses.get(i));
            chooseViruses(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void spread(List<int[]> activeViruses) {
        int[][] time = new int[N][N];
        for (int[] row : time) Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : activeViruses) {
            queue.add(virus);
            time[virus[0]][virus[1]] = 0;
        }

        int maxTime = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && time[nr][nc] == -1 && lab[nr][nc] != 1) {
                    time[nr][nc] = time[r][c] + 1;
                    queue.add(new int[]{nr, nc});

                    if (lab[nr][nc] == 0) {
                        maxTime = Math.max(maxTime, time[nr][nc]);
                    }
                }
            }
        }

        if (allInfected(time)) {
            minTime = Math.min(minTime, maxTime);
        }
    }

    static boolean allInfected(int[][] time) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 0 && time[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
