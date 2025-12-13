package 백준.골드.이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 갯수

        for(int i = 0; i < T; i++) {
            Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            // Q에 적용되는 연산의 개수
            int k = Integer.parseInt(br.readLine());

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                // 연산과 정수 입력
                String operation = st.nextToken();
                int intValue = Integer.parseInt(st.nextToken());

                if("I".equals(operation)) {
                    minQueue.offer(intValue);
                    maxQueue.offer(intValue);
                    map.put(intValue, map.getOrDefault(intValue, 0) + 1);
                } else if("D".equals(operation)) {
                    if(intValue == 1) {
                        // 최댓값 삭제
                        validationQueue(maxQueue, map);
                        if(!maxQueue.isEmpty()) {
                            int maxVal = maxQueue.peek();
                            map.put(maxVal, map.getOrDefault(maxVal, 0) - 1);
                        }
                    } else {
                        // 최소값 삭제
                        validationQueue(minQueue, map);
                        if(!minQueue.isEmpty()) {
                            map.put(minQueue.peek(), map.getOrDefault(minQueue.peek(), 0) - 1);
                        }
                    }
                }
            }

            validationQueue(maxQueue, map);
            validationQueue(minQueue, map);

            if(maxQueue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQueue.poll() + " " + minQueue.poll());
            }
        }
    }

    // 큐에서 값을 꺼내고 그 값이 map에서 0인지 체크 후 큐 값에서 제거
    public static void validationQueue(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        while(!que.isEmpty() && map.getOrDefault(que.peek(), 0) == 0) {
            que.poll();
        }
    }
}
