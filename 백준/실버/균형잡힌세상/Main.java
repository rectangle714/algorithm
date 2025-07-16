package 백준.실버.균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while(true) {
            Stack<Character> stack = new Stack<>();

            line = br.readLine();
            if(line.equals(".")) break;

            boolean isTrue = true;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '(' || line.charAt(i) == '[') {
                    stack.push(line.charAt(i));
                } else if(line.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        isTrue = false;
                        break;
                    }
                } else if(line.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        isTrue = false;
                        break;
                    }
                }
            }

            if(isTrue && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
