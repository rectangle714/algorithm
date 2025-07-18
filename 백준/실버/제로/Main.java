package 백준.실버.제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if(val == 0) {
                stack.pop();
            } else {
                stack.push(val);
            }
        }

        int result = 0;
        for(int val : stack) {
            result += val;
        }

        System.out.println(result);
    }
}
