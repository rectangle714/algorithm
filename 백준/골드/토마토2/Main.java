package 백준.골드.토마토2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1 - 익은 토마토, 0 - 익지 않은 토마토, -1 - 존재하지 않는 토마토
*/
public class Main {
    static int[] moveX = {1, -1, 0, 0, 0, 0};
    static int[] moveY = {0, 0, -1, 1, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();
    static int[][][] tomatoArr;
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());    // 가로
        N = Integer.parseInt(st.nextToken());    // 세로
        H = Integer.parseInt(st.nextToken());    // 높이
        tomatoArr = new int[H][N][M];

        // 토마토 값 입력,
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    tomatoArr[i][j][k] = value;
                    if(value == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }
        bfs();
        result();
    }

    public static void result() {
        int countDay = 0;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int z = 0; z < M; z++) {
                    if(tomatoArr[i][j][z] == 0) {
                        // 익지 않은 토마토가 한개라도 있으면 -1 출력
                        System.out.println(-1);
                        return;
                    } else {
                        countDay = Math.max(tomatoArr[i][j][z], countDay);
                    }
                }
            }
        }

        if(countDay == 1) {
            // countDay 값이 1이면 다 익었다는 것을 의미
            System.out.println(0);
        } else {
            // countDay에서 1을 뺀 값이 정답
            System.out.println(countDay - 1);
        }

    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int z = point.z;
            int x = point.x;
            int y = point.y;

            for(int i = 0; i < 6; i++) {
                int mz = z + moveZ[i];
                int mx = x + moveX[i];
                int my = y + moveY[i];

                // 토마토 주변 탐색 시작
                if(mx >= 0 && my >= 0 && mz >= 0
                    && mx < N && my < M && mz < H) {
                    // 주변에 익지 않은 토마토가 존재할 때
                    if(tomatoArr[mz][mx][my] == 0) {
                        // 익지않은 토마토를 Queue에 넣고,
                        // 날짜 계산을 위해서 현재 위치 토마토의 값 +1을 해준다.
                        queue.add(new Point(mz, mx, my));
                        tomatoArr[mz][mx][my] = tomatoArr[z][x][y] + 1;
                    }
                }
            }
        }
    }

    static class Point {
        int z, x, y;

        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}