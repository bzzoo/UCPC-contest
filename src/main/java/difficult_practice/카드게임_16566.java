package difficult_practice;

import java.io.*;
import java.util.Arrays;

import java.util.StringTokenizer;

public class 카드게임_16566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[M];
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards); // 이분탐색을 위한 정렬
        st = new StringTokenizer(br.readLine());
        boolean[] used = new boolean[M];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int chulsuCard = Integer.parseInt(st.nextToken());

            int minsuCardIdx = findMinsuCard(cards, used, chulsuCard);
            used[minsuCardIdx] = true;
            sb.append(cards[minsuCardIdx]).append('\n');
        }

        System.out.print(sb);
    }

    private static int findMinsuCard(int[] cards, boolean[] used, int target) {
        int left = 0;
        int right = cards.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (result == -1) {
            for (int i = 0; i < cards.length; i++) {
                if (!used[i]) {
                    return i;
                }
            }
        } else {
            for (int i = result; i < cards.length; i++) {
                if (!used[i] && cards[i] > target) {
                    return i;
                }
            }
            for (int i = 0; i < cards.length; i++) {
                if (!used[i]) {
                    return i;
                }
            }
        }
        return 0;
    }
}