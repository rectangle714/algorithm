package 백준.바닥장식;

import java.util.Scanner;

public class Main {
    /* 바닥 장식 */
    private static int result;
    private static int N, M;
    private static boolean[][] visited;
    private static String[][] tileArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        tileArr = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = sc.nextLine();
            for(int j=0; j<line.length(); j++) {
                tileArr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) { continue; }
                if("-".equals(tileArr[i][j])) dfs(i, j, true);
                else dfs(i, j, false);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int i, int j, boolean val) {
        if(N == i || M == j) { return; }
        visited[i][j] = true;
        if(val) {
            j++;
            if(j<M && "-".equals(tileArr[i][j])) dfs(i, j, true);
        } else {
            i++;
            if(i<N && !"-".equals(tileArr[i][j])) dfs(i, j, false);
        }

    }
}
