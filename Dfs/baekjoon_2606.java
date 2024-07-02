package Dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 바이러스 */
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
        }

        dfs(1);

        System.out.println(result-1);

    }

    private static void dfs(int idx) {
        if(visited[idx]) { return; }
        visited[idx] = true;
        result++;

        for(int i=0; i<n+1; i++) {
            if(arr[i][idx] == 1 || arr[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }
}
