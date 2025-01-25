package basic_practice.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("pop")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.removeLast() + "\n");
            }
            else if (cmd[0].equals("push")){
                stack.addLast(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("size")) {
                bw.write(stack.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                if (stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if (cmd[0].equals("top")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.peekLast() + "\n");
            }
        }
    }
}
