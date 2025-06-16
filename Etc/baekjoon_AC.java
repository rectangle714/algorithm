package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class baekjoon_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();                   // 수행할 함수
            int n = Integer.parseInt(br.readLine());    // 배열에 들어있는 수의 개수
            String line = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            if(n != 0) {
                String[] strArr = line.substring(1, line.length() - 1).split(",");
                for (String val : strArr) {
                    deque.offer(Integer.parseInt(val));
                }
            }

            boolean isReverse = false;                  // 배열을 뒤집을지 여부
            boolean isError = false;                    // "error"를 출력할지 여부
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else {
                    // char 값이 'D'인데 dequeue 값이 비어있으면 error 출력
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (isReverse) {
                        sb.append(deque.pollLast()).append(",");
                    } else {
                        sb.append(deque.poll()).append(",");
                    }
                }
                if(sb.length() > 1) {
                    sb.setLength(sb.length() - 1);
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
