package basic_practice.force;

import java.util.*;

public class 구슬탈출2_13460 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };

    static class State {
        int ar, ac, br, bc, count;

        public State(int ar, int ac, int br, int bc, int count) {
            this.ar = ar;
            this.ac = ac;
            this.br = br;
            this.bc = bc;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int ar = 0, ac = 0, br = 0, bc = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    ar = i;
                    ac = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    br = i;
                    bc = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(ar, ac, br, bc));
    }

    static int bfs(int ar, int ac, int br, int bc) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(ar, ac, br, bc, 0));
        visited[ar][ac][br][bc] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.count >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                int nar = current.ar;
                int nac = current.ac;
                int nbr = current.br;
                int nbc = current.bc;
                boolean redHole = false, blueHole = false;

                while (map[nar + dr[i]][nac + dc[i]] != '#') {
                    nar += dr[i];
                    nac += dc[i];
                    if (map[nar][nac] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while (map[nbr + dr[i]][nbc + dc[i]] != '#') {
                    nbr += dr[i];
                    nbc += dc[i];
                    if (map[nbr][nbc] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if (blueHole) continue;

                if (redHole) return current.count + 1;

                if (nar == nbr && nac == nbc) {
                    if (Math.abs(nar - current.ar) + Math.abs(nac - current.ac) >
                        Math.abs(nbr - current.br) + Math.abs(nbc - current.bc)) {
                        nar -= dr[i];
                        nac -= dc[i];
                    } else {
                        nbr -= dr[i];
                        nbc -= dc[i];
                    }
                }

                if (!visited[nar][nac][nbr][nbc]) {
                    visited[nar][nac][nbr][nbc] = true;
                    queue.add(new State(nar, nac, nbr, nbc, current.count + 1));
                }
            }
        }

        return -1;
    }
}
