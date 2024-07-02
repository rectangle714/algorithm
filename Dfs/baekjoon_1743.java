package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 음식물 피하기 */
public class baekjoon_1743 {

    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static int result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    dfs(i,j);
                    result = Integer.max(result, count);
                    count = 0;
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int x, int y) {
        if(visited[x][y]) { return; }
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++) {
            int dx = moveX[i] + x;
            int dy = moveY[i] + y;

            if(dx>=0 && dy>=0 && dx<N && dy<M && !visited[dx][dy] && arr[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }

}
