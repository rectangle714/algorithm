package 백준.실버.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int n, count;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};
    private static int arr[][];
    private static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();

            for(int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        List<Integer> countList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    countList.add(count);
                }
            }
        }

        System.out.println(countList.size());
        Collections.sort(countList);
        for(int val : countList) {
            System.out.println(val);
        }
    }

    public static void dfs(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];

            if(dx > -1 && dy > -1 && dx < n && dy < n && arr[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }
}
