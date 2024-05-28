package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 양치기 꿍 */
public class baekjoon_3187 {

    // '.' = 빈공간
    // '#' = 울타리
    // 'k' = 양
    // 'v' = 늑대
    static char[][] map;
    static boolean[][] visited;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int R;
    static int C;
    static int sheep = 0, wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int sheep_total = 0;
        int wolf_total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 1. 방문하지 않은 곳이고 #이 아니면 dfs 시작
                if (!visited[i][j] && map[i][j] != '#') {
                    sheep = 0; wolf = 0;
                    dfs(i, j);
                    //  3. '.' 구역에서 더한 양과 늑대의 숫자를 비교해서 양과 늑대의 total 값에 더해준다.
                    if (sheep > wolf) {
                        sheep_total += sheep;
                    } else {
                        wolf_total += wolf;
                    }
                }
            }
        }

        System.out.println(sheep_total + " " + wolf_total);
    }

    private static void dfs(int x, int y) {
        if ('k' == map[x][y]) {
            sheep++;
        } else if ('v' == map[x][y]) {
            wolf++;
        }
        visited[x][y] = true;

        //  2. '.'인 부분을 dfs로 확인하면서 양의 숫자와 늑대의 숫자 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[nx][ny] && map[nx][ny] != '#') {
                    dfs(nx, ny);
                }
            }
        }
    }

}
