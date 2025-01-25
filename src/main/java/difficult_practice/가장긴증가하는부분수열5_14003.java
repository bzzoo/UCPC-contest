package difficult_practice;

import java.io.*;

import java.util.*;

public class 가장긴증가하는부분수열5_14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        int[] indexTrace = new int[N];
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        dp[0] = 1;
        indexTrace[0] = 0;

        for(int i = 1; i < N; i++) {
            if(arr[i] > lis.get(lis.size()-1)) {
                lis.add(arr[i]);
                dp[i] = lis.size();
                indexTrace[i] = lis.size()-1;
            } else {
                int pos = Collections.binarySearch(lis, arr[i]);
                if(pos < 0) {
                    pos = -pos - 1;
                    lis.set(pos, arr[i]);
                    dp[i] = pos + 1;
                    indexTrace[i] = pos;
                }
            }
        }

        System.out.println(lis.size());

        int[] result = new int[lis.size()];
        int index = lis.size()-1;
        for(int i = N-1; i >= 0; i--) {
            if(dp[i] == index+1) {
                result[index] = arr[i];
                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}