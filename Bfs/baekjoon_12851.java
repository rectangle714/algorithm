package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 숨바꼭질 2 */
public class baekjoon_12851 {
    static int[] visited = new int[100001];
    static int k;
    static int count;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 수빈이가 있는 위치
        k = Integer.parseInt(st.nextToken());       // 동생이 있는 위치

        if(n >= k) {
            System.out.println(n-k);
            System.out.println(1);
        } else {
            bfs(n);
            System.out.println(result);
            System.out.println(count);
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(idx);
        visited[idx] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                if (result > visited[current]) {
                    result = visited[current];
                    count = 1;
                } else if (result == visited[current]) {
                    count++;
                }
                continue;
            }

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000) {
                    if (visited[next] == 0 || visited[next] >= visited[current] + 1) {
                        visited[next] = visited[current] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
