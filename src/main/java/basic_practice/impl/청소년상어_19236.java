package basic_practice.impl;

import java.util.Scanner;

public class 청소년상어_19236 {
    static Fish[][] fishes = new Fish[4][4];
    static int result = 0;
    static int[] shark = new int[3];
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int idx = sc.nextInt() - 1;
                int dir = sc.nextInt() - 1;
                fishes[i][j] = new Fish(idx, i, j, dir);
            }
        }

        Fish firstFish = fishes[0][0];
        int firstScore = firstFish.idx + 1;
        shark[2] = firstFish.dir;
        fishes[0][0] = null;

        moveFishes();
        dfs(0, 0, firstScore);

        System.out.println(result);
    }

    static void dfs(int sharkR, int sharkC, int totalScore) {
        result = Math.max(result, totalScore);

        Fish[][] backup = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (fishes[i][j] != null) {
                    backup[i][j] = new Fish(
                            fishes[i][j].idx,
                            fishes[i][j].r,
                            fishes[i][j].c,
                            fishes[i][j].dir
                    );
                }
            }
        }
        int[] backupShark = shark.clone();

        for (int dist = 1; dist < 4; dist++) {
            int nr = sharkR + dr[shark[2]] * dist;
            int nc = sharkC + dc[shark[2]] * dist;

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
            if (fishes[nr][nc] == null) continue;

            Fish fish = fishes[nr][nc];
            fishes[nr][nc] = null;

            shark = new int[]{nr, nc, fish.dir};

            moveFishes();

            dfs(nr, nc, totalScore + fish.idx + 1);

            shark = backupShark.clone();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (backup[i][j] != null) {
                        fishes[i][j] = new Fish(
                                backup[i][j].idx,
                                backup[i][j].r,
                                backup[i][j].c,
                                backup[i][j].dir
                        );
                    } else {
                        fishes[i][j] = null;
                    }
                }
            }
        }
    }

    static void moveFishes() {
        for (int k = 0; k < 16; k++) {
            outer: for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (fishes[i][j] != null && fishes[i][j].idx == k) {
                        moveFish(fishes[i][j]);
                        break outer;
                    }
                }
            }
        }
    }

    static void moveFish(Fish fish) {
        for (int d = 0; d < 8; d++) {
            int nextDir = (fish.dir + d) % 8;
            int nr = fish.r + dr[nextDir];
            int nc = fish.c + dc[nextDir];

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
            if (nr == shark[0] && nc == shark[1]) continue;

            fish.dir = nextDir;
            if (fishes[nr][nc] == null) {
                fishes[fish.r][fish.c] = null;
                fish.r = nr;
                fish.c = nc;
                fishes[nr][nc] = fish;
            } else {
                Fish target = fishes[nr][nc];
                fishes[fish.r][fish.c] = target;
                fishes[nr][nc] = fish;

                target.r = fish.r;
                target.c = fish.c;
                fish.r = nr;
                fish.c = nc;
            }
            break;
        }
    }

    static class Fish implements Comparable<Fish> {
        int idx, r, c, dir;

        public Fish(int idx, int r, int c, int dir) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        @Override
        public int compareTo(Fish other) {
            return Integer.compare(this.idx, other.idx);
        }
    }
}