package basic_practice.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어른상어_19237 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Node[][] nodes;
    static Shark[] sharks;
    static int N, M, k;
    static int[][][] primeDirection;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nodes = new Node[N][N];
        sharks = new Shark[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input != 0) {
                    sharks[input - 1] = new Shark(input, i, j);
                    nodes[i][j] = new Node(i, j, input, k);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (Shark shark : sharks) {
            shark.direction = Integer.parseInt(st.nextToken());
        }

        primeDirection = new int[M][4][4];
        for (int i = 0; i < M; i++) {

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    primeDirection[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int second = 0;
        debugShark();
        while (true) {
            if (second >= 1000) {
                System.out.println(-1);
                return;
            }

            int count = 0;
            for (Shark shark : sharks) {
                if (shark != null) {
                    count++;
                }
            }

            if (count == 1 && sharks[0] != null) {
                break;
            }

            for (Shark shark : sharks) {
                if (shark == null) {
                    continue;
                }
                move(shark);

            }
            //debugShark();
            reduceSmell();
            leaveSmell();
            //debugSmell();
            second++;

        }

        System.out.println(second);
    }

    static void debugShark() {
        for (Shark shark : sharks) {
            if(shark == null) continue;
            System.out.println("idx: " + shark.idx + " 행: " + shark.r + " 열: " + shark.c + " 방향: " + shark.direction );
        }
        System.out.println();
    }

    static void debugSmell(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nodes[i][j] != null) {
                    System.out.print("(" + nodes[i][j].idx + "," + nodes[i][j].remain + ") ");
                } else {
                    System.out.print("(" + 0 + "," + 0 + ") ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



    static void reduceSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nodes[i][j] != null) {
                    Node node = nodes[i][j];
                    if (node.remain > 0) {
                        node.remain--;
                        if (node.remain == 0) {
                            nodes[i][j] = null;
                        }
                    }
                }
            }
        }
    }

    static void leaveSmell() {
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (sharks[i] == null || sharks[j] == null) {
                    continue;
                }
                if (sharks[i].r == sharks[j].r && sharks[j].c == sharks[i].c) {
                    sharks[j] = null;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (sharks[i] != null) {
                Shark shark = sharks[i];
                if (nodes[shark.r][shark.c] == null) {
                    nodes[shark.r][shark.c] = new Node(shark.r, shark.c, shark.idx, k);
                }
                else {
                    nodes[shark.r][shark.c].remain = k;
                    nodes[shark.r][shark.c].idx = shark.idx;
                }
            }
        }
    }

    static void move(Shark shark) {
        int nr = shark.r;
        int nc = shark.c;
        int nd = -1;

        for (int i = 0; i < 4; i++) {
            int tempDir = primeDirection[shark.idx - 1][shark.direction - 1][i];
            int tempR = shark.r + dr[tempDir - 1];
            int tempC = shark.c + dc[tempDir - 1];

            if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N) {
                if (nodes[tempR][tempC] == null) {
                    nr = tempR;
                    nc = tempC;
                    nd = tempDir;
                    break;
                }
            }
        }

        if (nd == -1) {
            for (int i = 0; i < 4; i++) {
                int tempDir = primeDirection[shark.idx - 1][shark.direction - 1][i];
                int tempR = shark.r + dr[tempDir - 1];
                int tempC = shark.c + dc[tempDir - 1];

                if (tempR >= 0 && tempR < N && tempC >= 0 && tempC < N) {
                    if (nodes[tempR][tempC] != null && nodes[tempR][tempC].idx == shark.idx) {
                        nr = tempR;
                        nc = tempC;
                        nd = tempDir;
                        break;
                    }
                }
            }
        }


        if (nd == -1) {
            nd = shark.direction;
        }

        shark.r = nr;
        shark.c = nc;
        shark.direction = nd;
    }


    static class Node {

        int r, c;
        int idx;
        int remain;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int idx, int remain) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.remain = remain;
        }
    }

    static class Shark {

        int idx;
        int r;
        int c;
        int direction;

        public Shark(int idx, int r, int c) {
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
    }


}
