package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/* 숫자판 점프 */
public class baekjoon_2210 {

    static int x, y;
    static int[][] map;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static Set<String> result;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = 5;
        y = 5;
        map = new int[5][5];
        result = new HashSet<>();
        selected = new int[6];

        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs(0, i, j);
            }
        }

        System.out.println(result.size() + "");

    }

    static void dfs(int depth, int x, int y) {
        if(depth == 6) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++) {
                sb.append(selected[i]);
            }
            result.add(sb.toString());
            return;
        }

        for(int i=0; i<4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(dx>=0 && dy>=0 && dx<5 && dy<5) {
                selected[depth] = map[dx][dy];
                dfs(depth+1, dx, dy);
            }
        }
    }
}
