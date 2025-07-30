package 백준.실버.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 숨바꼭질 */
public class Main {
    static int[] visited = new int[100001];
    static int k;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 수빈이가 있는 위치
        k = Integer.parseInt(st.nextToken());       // 동생이 있는 위치

        if(n == k) {
            System.out.println(0);
        } else {
            bfs(n);
            System.out.println(count);
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(idx);
        visited[idx] = 1;
        while(!queue.isEmpty()) {
            int queueVal = queue.poll();

            for(int i=0; i<3; i++) {
                int next = 0;
                if(i == 0) { next = queueVal + 1; }
                if(i == 1) { next = queueVal - 1; }
                if(i == 2) { next = queueVal * 2; }

                if(next == k) {
                    System.out.println(visited[queueVal]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[queueVal] + 1;
                }
            }
        }
    }
}
