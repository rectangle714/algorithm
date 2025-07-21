package 백준.실버.스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // stack에 1 입력
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        sb.append("+").append("\n");
        int index = 2;
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(index++);
                sb.append("+").append("\n");
            }

            while(true) {
                int peekVal = stack.peek();
                // stack의 peek 값이 목표값보다 크면 불가능 판단
                if(!stack.isEmpty() && peekVal > arr[i]) {
                    System.out.println("NO");
                    return;
                }

                if(peekVal == arr[i]) {
                    sb.append("-").append("\n");
                    stack.pop();
                    break;
                } else {
                    sb.append("+").append("\n");
                    stack.push(index++);
                }
            }
        }

        System.out.println(sb);
    }
}
