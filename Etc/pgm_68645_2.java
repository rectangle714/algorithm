package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 삼각 달팽이 O(N²) 2번쨰 방식*/
public class pgm_68645_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int x = 0;
        int y = 0;
        int d = 0;
        int index = 1;
        int totalNum = n * (n + 1) / 2;

        /* 아래, 오른쪽, 위 왼쪽 정의 */
        final int[] dx = {0, 1, -1};
        final int[] dy = {1, 0, -1};

        while(index <= totalNum) {
            arr[y][x] = index++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(arr[i][j]);
            }
        }
    }
}
