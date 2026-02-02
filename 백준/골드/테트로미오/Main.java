package 백준.골드.테트로미오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int maxVal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 세로
        M = Integer.parseInt(st.nextToken());       // 가로
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dfs(i, j, 1, arr[i][j]);
                checkOther(i,j);
            }
        }

        System.out.println(maxVal);
    }

    // DFS로 depth 4까지 이동해서 큰값 구하기
    public static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            maxVal = Math.max(maxVal, sum);
            return;
        }

        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(0 <= dx && dx < N && 0 <= dy && dy < M && !visited[dx][dy]) {
                dfs(dx, dy, depth + 1, sum + arr[dx][dy]);
            }
        }

        visited[x][y] = false;
    }

    // 'ㅓ','ㅏ','ㅗ','ㅜ' 모양 탐색
    public static void checkOther(int x, int y) {
        int sum = arr[x][y];
        int min = Integer.MAX_VALUE;
        int wings = 0;

        for(int i = 0; i < 4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(0 <= dx && dx < N && 0 <= dy && dy < M) {
                wings++;
                sum += arr[dx][dy];
                min = Math.min(min, arr[dx][dy]);
            }
        }

        // 4방향 모두 더했을 때()는 가장 작은 값을 sum에서 빼주면 됨
        if(wings == 4) {
            sum -= min;
        }


        maxVal = Math.max(maxVal, sum);
    }
}
