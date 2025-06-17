package 백준.섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 섬의 개수 */
public class Main {

    static int w;
    static int h;
    static int result;
    static int moveX[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int moveY[] = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new int[w][h];
            visited = new boolean[w][h];

            if(w == 0 && h == 0) { break; }

            for(int i=0; i<w; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int j = 0;
                while(st2.hasMoreTokens()) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                    j++;
                }
            }

            result = 0;
            for(int i=0; i<w; i++) {
                for(int j=0; j<h; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        if(visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for(int i=0; i<8; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(dx>=0 && dy>=0 && dx<w && dy<h) {
                if(!visited[dx][dy] && map[dx][dy] == 1) {
                    dfs(dx, dy);
                }
            }

        }
    }
}
