package basic_practice.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 후위표기식_1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        Deque<Character> stack = new LinkedList<>();

        for(char c : input){
            if(c >= 'A' && c <= 'Z'){
                sb.append(c);
            }
            else if (c == '('){
                stack.addLast(c);
            }
            else if (c == ')'){
                while(!stack.isEmpty() && stack.peekLast() != '('){
                    sb.append(stack.pollLast());
                }
                stack.pollLast();
            }
            else{
                while(!stack.isEmpty() && priority(stack.peekLast()) >= priority(c)){
                    sb.append(stack.pollLast());
                }
                stack.addLast(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        System.out.println(sb.toString());
    }

    public static int priority(char c){
        if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0;
    }
}
