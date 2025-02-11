package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {

    static int N, L, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (canPassRow(i)) {
                result++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (canPassCol(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean canPassRow(int r) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            if (map[r][i] == map[r][i + 1]) {
                continue;
            }
            if (Math.abs(map[r][i] - map[r][i + 1]) > 1) {
                return false;
            }
            if(map[r][i] < map[r][i+1]){
                for(int j  = 0; j < L; j++){
                    if(i - j < 0 || visited[i-j] || map[r][i-j] != map[r][i]) return false;
                    visited[i-j] = true;
                }
            } else {
                for(int j = 0; j <L; j++){
                    if(i+1+j >=N || visited[i+1+j] || map[r][i+1+j] != map[r][i+1]) return false;
                    visited[i+1+j] = true;
                }
            }
        }
        return true;
    }

    static boolean canPassCol(int c) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            if (map[i][c] == map[i + 1][c]) continue;

            if (Math.abs(map[i][c] - map[i + 1][c]) > 1) return false;

            if (map[i][c] < map[i + 1][c]) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || visited[i - j] || map[i - j][c] != map[i][c]) return false;
                    visited[i - j] = true;
                }
            } else {
                for (int j = 0; j < L; j++) {
                    if (i + 1 + j >= N || visited[i + 1 + j] || map[i + 1 + j][c] != map[i + 1][c]) return false;
                    visited[i + 1 + j] = true;
                }
            }
        }
        return true;
    }
}
