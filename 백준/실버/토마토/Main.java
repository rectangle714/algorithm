package 백준.실버.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dayCount = 0;
    static final int[] DX = {-1, 1, 0, 0};
    static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());       // 가로 길이
        int y = Integer.parseInt(st.nextToken());       // 세로 길이

        int[][] arr = new int[y][x];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) queue.offer(new int[]{ i, j });
            }
        }

        bfs(arr, queue);

        boolean valid = true;       // 모든 토마토를 익힐 수 있는지 체크
        for(int[] line : arr) {
            if(Arrays.stream(line).anyMatch(value -> value == 0)) {
                valid = false;
            }
        }

        System.out.println(valid ? dayCount : -1);

    }

    public static void bfs(int[][] arr, Queue<int[]> queue) {
        int height = arr.length - 1;
        int width = arr[0].length - 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int s = 0; s < size; s++) {
                int[] val = queue.poll();
                for(int i=0; i<4; i++) {
                    int x = val[0] + DX[i];
                    int y = val[1] + DY[i];

                    if(x < 0 || y < 0 || x > height || y > width) continue;
                    if(arr[x][y] != 0) continue;

                    queue.offer(new int[]{x,y});
                    arr[x][y] = 1;
                }
            }

            if(!queue.isEmpty()) {
                dayCount++;
            }
        }
    }
}
