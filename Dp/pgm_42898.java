package Dp;

/**
 * 등굣길
 */
public class pgm_42898 {
    public static void main(String[] args) {
        System.out.println(solution(4,3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n][m];
        arr[0][0] = 1;

        for(int[] puddle : puddles) {
            int y = puddle[0] - 1;
            int x = puddle[1] - 1;
            arr[x][y] = -1;
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                    continue;
                }

                if(i > 0) { arr[i][j] += arr[i-1][j] % 1000000007; }
                if(j > 0) { arr[i][j] += arr[i][j-1] % 1000000007; }
            }
        }

        return arr[n - 1][m - 1] % 1000000007;
    }
}
