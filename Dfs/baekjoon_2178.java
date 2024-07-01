package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로 탐색 */
public class baekjoon_2178 {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int sum;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(0,0);
        System.out.println(arr[N-1][M-1]);

    }

    private static void bfs(int x, int y) {
        if(visited[x][y]) { return; }
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] queueVal = queue.poll();
            for(int i=0; i<4; i++) {
                int dx = moveX[i] + queueVal[0];
                int dy = moveY[i] + queueVal[1];

                if(!(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy])) {
                    continue;
                }
                if(arr[dx][dy] == 0) {
                    continue;
                }

                queue.offer(new int[]{dx,dy});
                arr[dx][dy] = arr[queueVal[0]][queueVal[1]] + 1;
                visited[dx][dy] = true;
            }
        }

    }
}
