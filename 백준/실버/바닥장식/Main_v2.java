package 백준.실버.바닥장식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_v2 {
    /* 바닥 장식 */

    private static int N, M;
    private static String[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) { continue; }
                dfs(i, j, arr[i][j]);
                result++;
            }
        }
        System.out.println(result);

    }

    public static void dfs(int i, int j, String val) {
        if(N == i || M == j) { return; }
        if(!val.equals(arr[i][j])) { return; }
        visited[i][j] = true;
        if("-".equals(arr[i][j])) {
            dfs(i, j+1, val);
        } else {
            dfs(i+1, j, val);
        }
    }

}
