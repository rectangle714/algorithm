package Dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_1012 {

    static ArrayList<int[][]> arr;
    static boolean[][] visited;
    static int M, N, K;
    static int count;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr.add(new int[M][N]);
            visited = new boolean[M][N];

            for(int j=0; j<K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr.get(i)[x][y] = 1;
            }

            for(int x=0; x<M; x++) {
                for(int y=0; y<N; y++) {
                    if(!visited[x][y] && arr.get(i)[x][y] == 1) {
                        dfs(x, y, i);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }



    }

    static void dfs(int x, int y, int index) {
        if(x >= M || y >= N ) {return;}
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];
            if(dx>=0 && dy>=0 && dx<M && dy<N) {
                if(!visited[dx][dy] && arr.get(index)[dx][dy] == 1) {
                    dfs(dx, dy, index);
                }
            }
        }

    }
}
