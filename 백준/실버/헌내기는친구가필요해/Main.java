package 백준.실버.헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] arr;
    private static boolean[][] visited;
    private static int meetPeople = 0;
    private static int[] moveX = { -1, 1, 0, 0 };
    private static int[] moveY = { 0, 0, -1, 1 };
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);

                // 도연이의 위치 찾기
                if(arr[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        System.out.println(meetPeople == 0 ? "TT" : meetPeople);
    }

    public static void dfs(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        // 사람을 만났을때 meetPeople + 1
        if(arr[x][y] == 'P') meetPeople++;

        for(int i = 0; i < 4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(dx >= 0 && dy >= 0 && dx < n && dy < m && arr[dx][dy] != 'X') {
                dfs(dx, dy);
            }
        }
    }
}
