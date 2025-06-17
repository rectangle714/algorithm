package 백준.전쟁전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 전쟁 - 전투 */
public class Main {

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static int countW;
    static int countB;
    static int sum;
    static char preColor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    sum = 0;
                    preColor = arr[i][j];
                    dfs(i,j);
                    int countVal = sum * sum;
                    if(arr[i][j] == 'W') {
                        countW += countVal;
                    } else {
                        countB += countVal;
                    }
                }
            }
        }

        System.out.print(countW + " " + countB);
    }

    private static void dfs(int x, int y) {
        if(visited[x][y] || preColor != arr[x][y]) { return; }
        sum++;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int dx = moveX[i] + x;
            int dy = moveY[i] + y;

            if(dx >= 0 && dy >= 0 && dx < M && dy < N && !visited[dx][dy] && preColor == arr[dx][dy]) {
                dfs(dx,dy);
            }

        }

    }
}
