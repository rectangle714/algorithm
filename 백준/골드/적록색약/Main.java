package 백준.골드.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static String[][] arr;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new String[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for(int i = 1; i < N+1; i++) {
            String line = br.readLine();
            for(int j = 1; j < N+1; j++) {
                arr[i][j] = String.valueOf(line.charAt(j - 1));
            }
        }

        // 적록색약이 아닌사람 
        int count = 0;
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

        // R값을 전부 G로 변경
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(arr[i][j].equals("R")) {
                    arr[i][j] = "G";
                }
            }
        }

        // 입력된 count, visited 값 초기화
        count = 0;
        visited = new boolean[N + 1][N + 1];

        // 적록색약인 경우 dfs 시작
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb.toString());

    }

    static void dfs(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if(mx > 0 && mx < N + 1 &&
                    my > 0 && my < N + 1) {
                // 현재 위치의 색상과 두변 위치의 값이 동일하고 방문하지 않은 경우 dfs 호출
                if(arr[mx][my].equals(arr[x][y]) && !visited[mx][my]) {
                    dfs(mx, my);
                }
            }
        }
    }
}
