package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());       // 총 인원
        int K = Integer.parseInt(st.nextToken());       // K 번째 제거 반복

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (queue.size() != 1) {

            // K-1번째까지는 Queue에 추가해주고 K 번째에서는 꺼내준다.
            for (int i = 1; i <= K; i++) {
                if (i == K) {
                    sb.append(queue.poll()).append(", ");
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb.toString());
    }
}
