package 프로그래머스.야근지수;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 야근 지수
 */
public class pgm_12927 {
    public static void main(String[] args) {
        int[] works = {4, 3,3};    // 각 일의 작업량
        int n = 4;               // 퇴근까지 남은 시간

        solution(works, n);
    }

    private static int solution(int[] works, int n) {
        if(Arrays.stream(works).sum() < n) return 0;
        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int work : works) {
            queue.offer(work);
        }

        while(n-- > 0) {
            int val = queue.poll();
            if(val == 0) break;
            queue.offer(val - 1);
        }

        while(!queue.isEmpty()) {
            int val = queue.poll();
            result += val * val;
        }

        return result;
    }

    // 효율성 탈락
    private static long solutionFail(int[] works, int n) {
        long result = 0;

        if(Arrays.stream(works).sum() < n) return 0;

        while(n-- > 0) {
            int maxIdx = 0;
            for(int i=0; i<works.length; i++) {
                if(works[maxIdx] < works[i]) {
                    maxIdx = i;
                }
            }

            works[maxIdx]--;
        }

        result = Arrays.stream(works)
                .map(val -> val * val)
                .sum();

        return result;
    }
}
