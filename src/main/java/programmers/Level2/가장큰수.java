package programmers.Level2;

import java.util.*;
public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            String[] strNumbers = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            Arrays.sort(strNumbers, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String order1 = o1 + o2;
                    String order2 = o2 + o1;
                    return order2.compareTo(order1);
                }
            });

            if (strNumbers[0].equals("0")) {
                return "0";
            }

            StringBuilder answer = new StringBuilder();
            for (String num : strNumbers) {
                answer.append(num);
            }
            return answer.toString();
        }
    }
}
