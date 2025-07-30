package 백준.실버.경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        // start에서 직접 연결된 값들 result 값에 추가
        for(int i = 0; i < n; i++) {
            if(arr[start][i] == 1) {
                queue.offer(i);
                visited[i] = true;
                result[start][i] = 1;
            }
        }

        // 이후에 연결된 값들을 추가
        while(!queue.isEmpty()) {
            int val = queue.poll();

            for(int i = 0; i < n; i++) {
                if(arr[val][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    result[start][i] = 1;
                }
            }
        }

    }

}
