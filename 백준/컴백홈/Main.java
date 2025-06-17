package 백준.컴백홈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /* 컴백홈 */
    static int R, C, K;
    static boolean[][] visit;
    static char[][] map;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        map = new char[R][C];
        visit[R-1][0] = true;

        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(R-1, 0, 1);
        System.out.println(result);
    }

    static void dfs(int x, int y, int k) {
        if(x ==0 && y == C-1) {
            if(k == K) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) { // map 안에 있는경우
                if (!visit[nx][ny] && map[nx][ny] != 'T') { // 방문하지 않은곳인 면서 T가 아닌곳
                    visit[nx][ny] = true;
                    dfs(nx, ny, k + 1);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
