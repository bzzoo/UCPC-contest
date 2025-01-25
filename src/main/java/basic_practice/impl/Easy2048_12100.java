package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Easy2048_12100 {
    static int N;
    static int[][] map;
    static int T = 5;
    static int[] arrows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrows = new int[T];
        Arrays.fill(arrows, -1);
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0);
        System.out.println(result);
    }

    static int result = Integer.MIN_VALUE;

    private static void func(int depth) {
        if (depth == T) {
            int[][] copy = copy(map);
            move(copy);
            findMax(copy);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arrows[depth] = i;
            func(depth + 1);
            arrows[depth] = -1;
        }
    }

    private static void move(int[][] map) {
        for (int i = 0; i < T; i++) {
            moving(arrows[i], map);
        }
    }

    private static void moving(int arrow, int[][] map) {
        //왼쪽몰이
        if (arrow == 0) {
            for (int i = 0; i < N; i++) {
                int p = 0;
                int prev = 0;
                int j = 0;

                while (j < N) {
                    if (map[i][j] != 0) {
                        if (map[i][j] == prev) {
                            map[i][p - 1] = prev * 2;
                            prev = 0;
                            map[i][j] = 0;
                        } else {
                            prev = map[i][j];
                            map[i][j] = 0;
                            map[i][p] = prev;
                            p++;
                        }
                    }
                    j++;
                }
            }
            //위쪽 몰이
        } else if (arrow == 1) {
            for (int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                int j = 0;
                while (j < N) {
                    if (map[j][i] != 0) {
                        if (block == map[j][i]) {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        } else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                    j++;
                }
            }

            //오른쪽 이
        } else if (arrow == 2) {
            for (int i = 0; i < N; i++) {
                int p = N - 1;
                int prev = 0;
                int j = N - 1;
                while (j >= 0) {
                    if (map[i][j] != 0) {
                        if (prev == map[i][j]) {
                            map[i][p + 1] = prev * 2;
                            prev = 0;
                            map[i][j] = 0;
                        } else {
                            prev = map[i][j];
                            map[i][j] = 0;
                            map[i][p] = prev;
                            p--;
                        }
                    }
                    j--;
                }
            }
        } else if (arrow == 3) {
            for (int i = 0; i < N; i++) {
                int p = N - 1;
                int prev = 0;
                int j = N - 1;
                while (j >= 0) {
                    if (map[j][i] != 0) {
                        if (prev == map[j][i]) {
                            map[p + 1][i] = prev * 2;
                            prev = 0;
                            map[j][i] = 0;
                        } else {
                            prev = map[j][i];
                            map[j][i] = 0;
                            map[p][i] = prev;
                            p--;
                        }
                    }
                    j--;
                }

            }
        }
    }

    static void findMax(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > result) {
//                    if(map[i][j] == 16){
//                        for(int k= 0; k<T;k++){
//                            System.out.print(arrows[k]);
//                        }
//                    }
                    result = map[i][j];
                }
            }
        }
    }

    static int[][] copy(int[][] map) {
        int[][] copyArray = new int[map.length][map.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyArray[i][j] = map[i][j];
            }
        }
        return copyArray;
    }
}
