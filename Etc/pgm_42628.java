package Etc;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 */
public class pgm_42628 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution(operations);
    }

    private static void solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());  // 최대값 우선순위
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();                            // 최솟값 우선순위
        for(String val : operations) {
            if(val.startsWith("I")) {
                maxQueue.offer(Integer.parseInt(val.split(" ")[1]));
                minQueue.offer(Integer.parseInt(val.split(" ")[1]));
            } else {
                if("1".equals(val.split(" ")[1])) {
                    minQueue.remove(maxQueue.poll());
                } else {
                    maxQueue.remove(minQueue.poll());
                }
            }
        }

        int maxValue = maxQueue.peek() == null ? 0 : maxQueue.peek();
        int minValue = minQueue.peek() == null ? 0 : minQueue.peek();
        System.out.println( maxValue  + "" + minValue);
    }
}
