package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N과 M (1) (백트래킹)*/
/* O(n^m) */
public class baekjoon_15649 {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == m) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
