package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 음식물 피하기 */
public class baekjoon_1743 {

    static int N, M, K;
    static int result;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);

    }

    private static void bfs(int x, int y) {
        if(visited[x][y]) { return; }
        visited[x][y] = true;
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        int count = 1;
        queue.offer(new Integer[]{x,y});

        while(!queue.isEmpty()) {
            Integer[] queueVal = queue.poll();
            for(int i=0; i<4; i++) {
                int dx = moveX[i] + queueVal[0];
                int dy = moveY[i] + queueVal[1];

                if(dx>=0 && dy>=0 && dx<N && dy<M
                        && !visited[dx][dy] && arr[dx][dy] == 1) {
                    count++;
                    visited[dx][dy] = true;
                    queue.offer(new Integer[]{dx, dy});
                }
            }
            result = Math.max(result, count);
        }
    }

}
