package basic_practice.greedy;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열2_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1; i < n; i++) {
            int num = arr[i];
            if(num > list.get(list.size()-1)) {
                list.add(num);
            } else {
                int left = 0;
                int right = list.size()-1;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(left, num);
            }
        }

        System.out.println(list.size());
    }
}
