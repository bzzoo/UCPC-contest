package basic_practice.dp;

import java.util.Scanner;

public class M경찰차_2618 {

    static int n, w;
    static Event[] events;
    static Patrol patrol1, patrol2;
    static int[][] dp, trace;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        w = sc.nextInt();

        trace = new int[w + 1][w + 1];
        dp = new int[w + 1][w + 1];

        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }

        patrol1 = new Patrol(1, 1);
        patrol2 = new Patrol(n, n);
        events = new Event[w];
        for (int i = 0; i < w; i++) events[i] = new Event(sc.nextInt(), sc.nextInt());
        System.out.println(rec(0));

        int p1 =0, p2 = 0;
        for(int i = 0; i < w; i++){
            System.out.println(trace[p1][p2]);
            if(trace[p1][p2] == 1) p1 = i + 1;
            else p2 = i + 1;
        }
    }

    private static int rec(int depth) {

        if (depth == w) return 0;

        if (dp[patrol1.eventNum][patrol2.eventNum] != -1)
            return dp[patrol1.eventNum][patrol2.eventNum];

        int nextDist1 = patrol1.calDist(events[depth].row, events[depth].col);
        int prevR1 = patrol1.row;
        int prevC1 = patrol1.col;
        int prevEventNum1 = patrol1.eventNum;

        patrol1.change(events[depth].row, events[depth].col, depth + 1);
        int result1 = rec(depth + 1) + nextDist1;
        patrol1.change(prevR1, prevC1, prevEventNum1);

        int nextDist2 = patrol2.calDist(events[depth].row, events[depth].col);
        int prevR2 = patrol2.row;
        int prevC2 = patrol2.col;
        int prevEventNum2 = patrol2.eventNum;

        patrol2.change(events[depth].row, events[depth].col, depth + 1);
        int result2 = rec(depth + 1) + nextDist2;
        patrol2.change(prevR2, prevC2, prevEventNum2);

        if (result1 < result2) {
            dp[patrol1.eventNum][patrol2.eventNum] = result1;
            trace[patrol1.eventNum][patrol2.eventNum] = 1;
        } else {
            dp[patrol1.eventNum][patrol2.eventNum] = result2;
            trace[patrol1.eventNum][patrol2.eventNum] = 2;
        }

        return dp[patrol1.eventNum][patrol2.eventNum];
    }

    static class Patrol {
        int row;
        int col;
        int eventNum = 0;

        public Patrol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int calDist(int row, int col) {
            return Math.abs(this.row - row) + Math.abs(this.col - col);
        }

        public void change(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.eventNum = depth;
        }
    }

    static class Event {
        int row;
        int col;

        public Event(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}