package Dfs;

import java.util.Scanner;

/*
* - 음료수 얼려먹기 -
* N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
* 구멍이 뚫려 있는 부분끼리 상,하,좌,우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
* 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
*/
public class ice_filling {
    private static int N = 0;
    private static int M = 0;
    private static int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<N; i++) {
            String str = sc.nextLine();
            for(int j=0; j<M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(bfs(i,j)){
                    result++;
                };
            }
        }

        System.out.println(result);
    }

    public static boolean bfs(int x, int y) {
        if(x <= -1 || x > N || y <= -1 || y >= M) {
            return false;
        }

        if(graph[x][y] == 0) {
            graph[x][y] = 1;

            bfs(x-1, y);
            bfs(x, y-1);
            bfs(x+1, y);
            bfs(x, y+1);
            return true;
        }
        return false;
    }
}
