package basic_practice.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상어중학교_21609 {

    static int N, M, result;
    static Integer[][] map;
    static ArrayList<int[]> blockSet;
    static ArrayList<BlockGroup> blockGroups;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class BlockGroup {
        ArrayList<int[]> blocks;
        int rainbowCount;
        int standardRow;
        int standardCol;

        BlockGroup(ArrayList<int[]> blocks, int rainbowCount, int standardRow, int standardCol) {
            this.blocks = blocks;
            this.rainbowCount = rainbowCount;
            this.standardRow = standardRow;
            this.standardCol = standardCol;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            // 블록 집합 찾기
            findBlockSet();

            // 블록 집합 없거나 크기 1 이하인 경우 종료
            if (blockSet == null || blockSet.size() <= 1) {
                break;
            }

            // 블록 집합 제거 및 점수 갱신
            removeBlockSet();

            // 중력 적용
            gravity();

            // 반시계 90도 회전
            rotate();

            // 다시 중력 적용
            gravity();
        }
        System.out.println(result);
    }

    static void gravity() {
        for (int c = 0; c < N; c++) {
            int r = N - 1;
            for (int rp = N - 1; rp >= 0; rp--) {
                if (map[rp][c] == null) continue;
                if (map[rp][c] == -1) {
                    r = rp - 1;
                } else {
                    if (r != rp) {
                        map[r][c] = map[rp][c];
                        map[rp][c] = null;
                    }
                    r--;
                }
            }
        }
    }

    static void rotate() {
        Integer[][] temp = new Integer[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[N - 1 - c][r] = map[r][c];
            }
        }
        map = temp;
    }

    static void removeBlockSet() {
        for (int[] point : blockSet) {
            map[point[0]][point[1]] = null;
        }
        result += (blockSet.size()) * (blockSet.size());
        blockSet = new ArrayList<>();
    }

    static void findBlockSet() {
        visited = new boolean[N][N];
        blockGroups = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) continue;
                if (map[i][j] == null || map[i][j] == -1 || map[i][j] == 0) continue;


                ArrayList<int[]> tempSet = new ArrayList<>();
                int rainbowCount = find(i, j, map[i][j], tempSet);

                if (tempSet.size() > 1) {
                    int standardRow = Integer.MAX_VALUE;
                    int standardCol = Integer.MAX_VALUE;

                    for (int[] point : tempSet) {
                        int r = point[0];
                        int c = point[1];
                        if (map[r][c] > 0) {
                            if (r < standardRow || (r == standardRow && c < standardCol)) {
                                standardRow = r;
                                standardCol = c;
                            }
                        }
                    }
                    blockGroups.add(new BlockGroup(tempSet, rainbowCount, standardRow, standardCol));
                }
            }
        }

        blockGroups.sort((o1, o2) -> {
            if (o1.blocks.size() != o2.blocks.size()) {
                return o2.blocks.size() - o1.blocks.size();
            }
            if (o1.rainbowCount != o2.rainbowCount) {
                return o2.rainbowCount - o1.rainbowCount;
            }
            if (o1.standardRow != o2.standardRow) {
                return o2.standardRow - o1.standardRow;
            }
            return o2.standardCol - o1.standardCol;
        });

        if (!blockGroups.isEmpty()) {
            blockSet = blockGroups.get(0).blocks;
        } else {
            blockSet = null;
        }
    }

    static int find(int r, int c, int color, ArrayList<int[]> tempSet) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] tempVisited = new boolean[N][N];
        q.add(new int[]{r, c});
        visited[r][c] = true;
        tempVisited[r][c] = true;

        int rainbowCount = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            tempSet.add(new int[]{now[0], now[1]});

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (map[nr][nc] == null || map[nr][nc] == -1) continue;
                if (map[nr][nc] != 0 && map[nr][nc] != color) continue;
                if (tempVisited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    rainbowCount++;
                } else {
                    visited[nr][nc] = true;
                }
                q.add(new int[]{nr, nc});
                tempVisited[nr][nc] = true;
            }
        }
        return rainbowCount;
    }
}
