package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 새로운게임2_17837 {

    static int N, K;
    static int[][] map;
    static List<Piece>[][] board;
    static Piece[] pieces;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Piece {
        int x, y, dir;
        public Piece(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        board = new ArrayList[N][N];
        pieces = new Piece[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            pieces[i] = new Piece(x, y, dir);
            board[x][y].add(pieces[i]);
        }

        System.out.println(solve());
    }

    static int solve() {
        for(int turn = 1; turn <= 1000; turn++) {
            for(int i = 0; i < K; i++) {
                Piece p = pieces[i];
                int x = p.x;
                int y = p.y;
                int nx = x + dx[p.dir];
                int ny = y + dy[p.dir];

                if(!isValid(nx, ny) || map[nx][ny] == 2) {
                    p.dir = p.dir % 2 == 0 ? p.dir + 1 : p.dir - 1;
                    nx = x + dx[p.dir];
                    ny = y + dy[p.dir];
                    if(!isValid(nx, ny) || map[nx][ny] == 2) continue;
                }

                int index = getIndex(x, y, p);
                List<Piece> moving = new ArrayList<>();
                for(int j = index; j < board[x][y].size(); j++) {
                    moving.add(board[x][y].get(j));
                }

                if(map[nx][ny] == 1) {
                    Collections.reverse(moving);
                }

                for(int j = board[x][y].size() - 1; j >= index; j--) {
                    board[x][y].remove(j);
                }

                for(Piece mp : moving) {
                    board[nx][ny].add(mp);
                    mp.x = nx;
                    mp.y = ny;
                }

                if(board[nx][ny].size() >= 4) return turn;
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static int getIndex(int x, int y, Piece p) {
        for(int i = 0; i < board[x][y].size(); i++) {
            if(board[x][y].get(i) == p) return i;
        }
        return -1;
    }
}
