package 백준.실버.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        double trimmedMean = Math.round(n * 0.15);

        for(int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬
        deque = deque.stream().sorted().collect(Collectors.toCollection(ArrayDeque::new));

        for(int i = 0; i < trimmedMean; i++) {
            deque.pollFirst();
            deque.pollLast();
        }

        int result = 0;
        for(int val : deque) {
            result += val;
        }

        // result / 절삭 내용을 뺀 전체 크기
        System.out.println(Math.round(result / (n - (trimmedMean * 2))));

    }
}
