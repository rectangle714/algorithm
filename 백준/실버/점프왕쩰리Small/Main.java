package 백준.실버.점프왕쩰리Small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /* 점프왕 쩰리 */
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));

    }

    public static String dfs(int i, int j) {
        int count = arr[i][j];
        visited[i][j] = true;

        if(count == -1) { return "HaruHaru"; }

        if(i + count < N  && !visited[i + count][j] && !dfs(i + count, j).equals("Hing")) {
            return "HaruHaru";
        }

        if(j + count < N  && !visited[i][j + count] && !dfs(i, j + count).equals("Hing")) {
            return "HaruHaru";
        }

        return "Hing";
    }
}
