package Dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1260 {

    /* DFS와 BFS */

    static int N, M, V;
    static boolean[] visited;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(V);
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb.toString());

    }

    public static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");
        for(int i=0; i<=N; i++) {
            if(arr[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        visited[V] = true;
        queue.offer(V);
        sb.append("\n").append(V).append(" ");
        while(!queue.isEmpty()) {
            int index = queue.poll();
            for(int i=0; i<=N; i++) {
                if(arr[index][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }

}
