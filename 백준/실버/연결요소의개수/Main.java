package 백준.실버.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연결 요소의 개수 */
public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[1001][1001];
        visited = new boolean[1001];

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        int result = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);

    }

    static void dfs(int index) {
        if(visited[index]) { return; }
        visited[index] = true;
        for(int i=1; i<=N; i++) {
            if(arr[index][i] == 1) {
                dfs(i);
            }
        }

    }

}
