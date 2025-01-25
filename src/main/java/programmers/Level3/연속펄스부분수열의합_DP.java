package programmers.Level3;

public class 연속펄스부분수열의합_DP {
    static long[] dpp;
    static long[] dpn;

    public long solution(int[] seq) {
        int len = seq.length;

        dpp = new long[len];
        dpn = new long[len];
        dpp[0] = seq[0];
        dpn[0] = -seq[0];

        for (int i = 1; i < len; i++) {
            if (i % 2 == 1) { //짝수일 때,
                dpp[i] = Math.max(dpp[i - 1] - seq[i], -seq[i]);
                dpn[i] = Math.max(dpn[i - 1] + seq[i], seq[i]);
            } else {
                dpp[i] = Math.max(dpp[i - 1] + seq[i], seq[i]);
                dpn[i] = Math.max(dpn[i - 1] - seq[i], -seq[i]);
            }
        }

        long answer = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, Math.max(dpp[i], dpn[i]));
        }
        return answer;
    }
}

