package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 스도쿠_2239 {

    static int[][] map;
    static ArrayList<Point> zeroList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        zeroList = new ArrayList<>();
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 0)
                    zeroList.add(new Point(i, j));
            }
        }
        func(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    static boolean isEnd = false;
    private static void func(int count) {
        if (count == zeroList.size()) {
            isEnd = true;
            return;
        }
        Point now = zeroList.get(count);
        for (int i = 1; i <= 9; i++) {
            map[now.x][now.y] = i;
            if (isNemoOk(now.x, now.y) && isHorizonOk(now.x, now.y) && isVerticalOk(now.x, now.y)) {
                func(count + 1);
            }
            if(isEnd) return;
            map[now.x][now.y] = 0;
        }
    }

    static boolean isNemoOk(int x, int y) {
        int jx = (x / 3) * 3;
        int jy = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x != jx + i || y != jy + j) {
                    if (map[jx + i][jy + j] == map[x][y]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isVerticalOk(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x) {
                if (map[i][y] == map[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isHorizonOk(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                if (map[x][i] == map[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }


    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
