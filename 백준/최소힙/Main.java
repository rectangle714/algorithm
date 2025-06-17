package 백준.최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {                  // 값이 0이면 출력
                if(queue.isEmpty()) {       // 출력 상황에 비어있으면 0 출력
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.offer(val);
            }
        }

    }
}
