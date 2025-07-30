package 백준.실버.카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/* 카드2 */
/* 시간복잡도 O(n) */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=1; i<n+1; i++) {
            deque.addLast(i);
        }

        int idx = 1;
        while(deque.size() != 1) {
            if(idx % 2 == 0) {
                int fstValue = deque.pollFirst();
                deque.offerLast(fstValue);
            } else {
                deque.poll();
            }
            idx++;
        }

        System.out.println(deque.getFirst());
    }
}
