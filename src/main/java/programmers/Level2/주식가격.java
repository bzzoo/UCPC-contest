package programmers.Level2;
import java.util.*;
public class 주식가격 {
    class Solution {

        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Deque<Integer> stack = new LinkedList<>();

            for(int i = 0; i < prices.length; i++){
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                    int pop = stack.pop();
                    answer[pop] = i-pop;
                }
                stack.push(i);
            }

            while(!stack.isEmpty()){
                answer[stack.peek()] = prices.length - stack.peek() - 1;
                stack.pop();
            }
            return answer;
        }
    }
}
