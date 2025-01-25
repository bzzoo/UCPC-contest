package basic_practice.force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {

    static int N, M, result;
    static boolean[] isBroken;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isBroken = new boolean[10];

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        while (true) {
            int min = Math.abs(N - 100);
            int len = possible(N);
            if (len > 0) {
                min = Math.min(min, len);
            }
            for (int i = 1; i < 1000000; i++) {
                len = possible(N + i);
                if (len > 0) {
                    min = Math.min(min, len + i);
                }
                len = possible(N - i);
                if (len > 0) {
                    min = Math.min(min, len + i);
                }
            }
            result = min;
            break;
        }
        System.out.println(result);
    }

    static int possible(int num) {
        if (num == 0) {
            return isBroken[0] ? 0 : 1;
        }
        int len = 0;
        while (num > 0) {
            if (isBroken[num % 10]) {
                return 0;
            }
            len++;
            num /= 10;
        }
        return len;
    }
}
