package 백준.실버.경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[n + 1];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());

                list[j].add(val);
            }
        }

        for(int i = 1; i <= n; i++) {
            bfs(i);
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[];
        queue.add(node);

        while(!queue.isEmpty()) {
            int value = queue.poll();


        }
    }
}
