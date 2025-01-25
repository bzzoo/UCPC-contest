package basic_practice.graph.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 불_4179 {
    static int R, C, answer=0;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static Queue<Point> person, fire;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        person = new LinkedList<>();
        fire = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'J') {
                    person.add(new Point(i, j, 0));
                } else if (map[i][j] == 'F') {
                    fire.add(new Point(i, j, 0));
                }
            }
        }
        boolean burn = burn();
        System.out.println(!burn ? "IMPOSSIBLE" : answer);
    }


    private static boolean burn() {
        while (!person.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Point p = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = p.r + dr[j];
                    int nc = p.c + dc[j];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (map[nr][nc] != '#' && map[nr][nc] != 'F') {
                        map[nr][nc] = 'F';
                        fire.add(new Point(nr, nc, p.time + 1));
                    }
                }
            }
            int p_size = person.size();
            for (int k = 0; k < p_size; k++) {
                Point p = person.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                        answer = p.time + 1;
                        return true;
                    }
                    if(map[nr][nc] != '#' && map[nr][nc] != 'F' && map[nr][nc] != 'J'){
                        person.add(new Point(nr, nc, p.time+1));
                        map[nr][nc] = 'J';
                    }
                }
            }
        }
        return false;
    }
    public static class Point {
        int r;
        int c;
        int time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}

