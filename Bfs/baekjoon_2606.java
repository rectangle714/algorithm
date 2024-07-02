package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2606 {

    static int n, m, result;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int idx) {
        visited[idx] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(idx);

        while(!queue.isEmpty()) {
            int queueVal = queue.poll();
            for(int i=0; i<n+1; i++) {
                if(arr[queueVal][i] == 1 && !visited[i]) {
                    result++;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
