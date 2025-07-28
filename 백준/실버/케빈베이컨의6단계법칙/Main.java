package 백준.실버.케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int minBacon = Integer.MAX_VALUE;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 유저의 수
        int m = Integer.parseInt(st.nextToken());       // 친구 관계의 수

        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            bfs(i, list);
        }

        System.out.println(result);
    }

    public static void bfs(int val, List<Integer>[] list) {
        boolean[] visited = new boolean[list.length];
        int[] distance = new int[list.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(val);
        visited[val] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int neighbor : list[current]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 베이컨 수를 비교하여 최소 베이컨과 result 값 갱신
        int bacon = Arrays.stream(distance).sum();
        if(bacon < minBacon) {
            minBacon = bacon;
            result = val;
        }
    }
}
