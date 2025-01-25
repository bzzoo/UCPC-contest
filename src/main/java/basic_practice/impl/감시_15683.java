package basic_practice.impl;

import java.util.ArrayList;
import java.util.Scanner;

public class 감시_15683 {

    static int N, M;
    static int[][] ori;
    static ArrayList<CCTV> tvs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        tvs = new ArrayList<>();
        ori = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ori[i][j] = sc.nextInt();
                if (ori[i][j] != 6 && ori[i][j] != 0) {
                    tvs.add(new CCTV(i, j, ori[i][j]));
                }
            }
        }

        refunc(0);
        System.out.println(sagak);
    }

    static int sagak = Integer.MAX_VALUE;

    private static void refunc(int depth) {
        if (depth == tvs.size()) {
            sagak = Math.min(sagak, cal());
            return;
        }
        for (int i = 0; i < 4; i++) {
            CCTV cctv = tvs.get(depth);
            cctv.setDir(i);
            refunc(depth + 1);
        }
    }

    private static int cal() {
        int res = 0;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = ori[i][j];
            }
        }

        for (CCTV tv : tvs)
            lotation(tv, copy);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 0) res++;
            }
        }
        return res;
    }

    private static void lotation(CCTV cctv, int[][] copy) {
        if (cctv.num == 1) {
            if(cctv.dir == 0) setRight(cctv, copy);
            else if(cctv.dir == 1) setUp(cctv,copy);
            else if(cctv.dir == 2) setLeft(cctv, copy);
            else setDown(cctv,copy);

        } else if (cctv.num == 2) {
            if(cctv.dir == 0 || cctv.dir == 2){
                setRight(cctv, copy);
                setLeft(cctv, copy);
            }
            else {
                setUp(cctv,copy);
                setDown(cctv,copy);
            }

        } else if (cctv.num == 3) {
            if(cctv.dir == 0) {
                setRight(cctv, copy);
                setUp(cctv,copy);
            }
            else if(cctv.dir == 1) {
                setUp(cctv,copy);
                setLeft(cctv, copy);
            }
            else if(cctv.dir == 2){
                setLeft(cctv, copy);
                setDown(cctv,copy);
            }
            else {
                setDown(cctv,copy);
                setRight(cctv, copy);
            }
        } else if( cctv.num == 4) {
            if(cctv.dir == 0) {
                setRight(cctv, copy);
                setUp(cctv,copy);
                setLeft(cctv, copy);
            }
            else if(cctv.dir == 1) {
                setUp(cctv,copy);
                setLeft(cctv, copy);
                setDown(cctv,copy);
            }
            else if(cctv.dir == 2){
                setLeft(cctv, copy);
                setDown(cctv,copy);
                setRight(cctv, copy);
            }
            else {
                setDown(cctv,copy);
                setRight(cctv, copy);
                setUp(cctv, copy);
            }
        } else {
            setLeft(cctv, copy);
            setUp(cctv, copy);
            setDown(cctv,copy);
            setRight(cctv, copy);
        }
    }

    private static void setLeft(CCTV cctv, int[][] copy) {
        for(int i = cctv.c - 1; i >= 0; i--) {
            if (copy[cctv.r][i] == 6) break;
            if (copy[cctv.r][i] == 0) copy[cctv.r][i] = 7;
        }
    }
    private static void setUp(CCTV cctv, int[][] copy) {
        for(int i = cctv.r - 1; i >= 0; i--) {
            if (copy[i][cctv.c] == 6) break;
            if (copy[i][cctv.c] == 0) copy[i][cctv.c] = 7;
        }
    }
    private static void setRight(CCTV cctv, int[][] copy) {
        for(int i = cctv.c + 1; i<M; i++) {
            if (copy[cctv.r][i] == 6) break;
            if (copy[cctv.r][i] == 0) copy[cctv.r][i] = 7;
        }
    }
    private static void setDown(CCTV cctv, int[][] copy) {
        for(int i = cctv.r + 1; i < N; i++) {
            if (copy[i][cctv.c] == 6) break;
            if (copy[i][cctv.c] == 0) copy[i][cctv.c] = 7;
        }
    }

    static class CCTV {
        int r, c;
        int num;
        int dir;

        public CCTV(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }
    }
}
