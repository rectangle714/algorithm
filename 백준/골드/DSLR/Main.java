package 백준.골드.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static String[] operation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(0 < T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            System.out.println(bfs(start, target));
        }
    }

    public static String bfs(int start, int target) {
        visited = new boolean[10000];
        operation = new String[10000];

        Queue<Integer> queue = new LinkedList<>();
        operation[start] = "";
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == target) return operation[now];

            // D
            int d = (now * 2) > 9999 ? (now * 2) % 10000 : (now * 2);
            if(!visited[d]) {
                setting(queue, now, d, "D");
            }

            // S
            int s = now == 0 ? 9999 : now - 1;
            if(!visited[s]) {
                setting(queue, now, s, "S");
            }

            // L
            int l = (now % 1000) * 10 + (now / 1000);
            if(!visited[l]) {
                setting(queue, now, l, "L");
            }

            // R
            int r = (now % 10) * 1000 + (now / 10);
            if(!visited[r]) {
                setting(queue, now, r, "R");
            }
        }

        return "";
    }

    public static void setting(Queue<Integer> queue, int now, int next, String add) {
        visited[next] = true;
        operation[next] = operation[now] + add;
        queue.offer(next);
    }
}
