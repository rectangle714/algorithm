package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_쉬운최단거리 {

    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 세로의 크기
        int m = Integer.parseInt(st.nextToken());       // 가로의 크기

        int[] start = new int[2];
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 목표지점 확인
                if(map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], -1);        // arr '배열 도달할 수 없는 위치' -1로 초기화
        }

        bfs(start[0], start[1], arr, map);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // map 배열에서 갈 수 없는 땅이면 0, 아니면 arr 배열의 값을 append
                if(map[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int x, int y, int[][] arr, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        // 처음 목표지점 queue 값 추가, visited true, arr 값 0 입력
        queue.offer(new int[]{ x, y });
        visited[x][y] = true;
        arr[x][y] = 0;
        while(!queue.isEmpty()) {
            int[] val = queue.poll();

            for(int i=0; i<4; i++) {
                int dx = val[0] + moveX[i];
                int dy = val[1] + moveY[i];

                if(dx < 0 || dx > arr.length-1 || dy < 0 || dy > arr[0].length-1) continue;
                if(visited[dx][dy]) continue;
                if(map[dx][dy] == 0) continue;

                visited[dx][dy] = true;
                queue.offer(new int[]{dx, dy});
                arr[dx][dy] = arr[val[0]][val[1]] + 1;
            }
        }
    }
}
