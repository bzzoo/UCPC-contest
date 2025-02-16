package programmers.Level2;

public class 완전범죄 {
    class Solution {

        static int N, M;
        static int[][] realInfo;
        static int[][][] dp;

        public int solution(int[][] info, int n, int m) {

            N = n;
            M = m;
            realInfo = info.clone();
            // for(int i = 0; i < realInfo.length; i++){
            //     for(int j = 0; j < realInfo[0].length; j++){
            //         System.out.print(realInfo[i][j]);
            //     }
            // }
            dp = new int[realInfo.length][N + 1][M + 1];
            for (int i = 0; i < info.length; i++) {
                for (int j = 0; j <= N; j++) {
                    for (int k = 0; k <= M; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }
            int result = rec_func(0, 0, 0);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        static int rec_func(int depth, int A, int B) {
            if (depth == realInfo.length) {
                if (A < N && B < M) {
                    return A;
                }
                return Integer.MAX_VALUE;
            }

            if (dp[depth][A][B] != -1) {
                return dp[depth][A][B];
            }

            int result = Integer.MAX_VALUE;
            if (A + realInfo[depth][0] <= N) {
                result =
                        Math.min(result,
                                rec_func(depth + 1, A + realInfo[depth][0], B));
            }

            if (B + realInfo[depth][1] <= M) {
                result =
                        Math.min(result,
                                rec_func(depth + 1, A, B + realInfo[depth][1]));
            }
            return dp[depth][A][B] = result;
        }
    }
}
