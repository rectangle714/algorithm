package 프로그래머스.등굣길;

/**
 * 등굣길
 */
public class pgm_42898 {
    public static void main(String[] args) {
        System.out.println(solution(4,3, new int[][]{{2, 2}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int MOD_VALUE =  1_000_000_007;
        int[][] arr = new int[n][m];
        // 시작점만 1로 채움
        arr[0][0] = 1;

        // 배열의 웅덩이 위치에 -1로 값을 채움
        for(int[] puddle : puddles) {
            int y = puddle[0] - 1;
            int x = puddle[1] - 1;
            arr[x][y] = -1;
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 웅덩이가 있는 위치는 0으로 값을 변경
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                    continue;
                }

                /*
                * 웅덩이가 없는 위치에는 왼쪽, 위 값을 더해주고,
                * 계속 누적되어 값이 너무 커지는 것을 막기 위해 매번 나머지 값을 구해줌
                */
                if(i > 0) { arr[i][j] += arr[i-1][j] % MOD_VALUE; }
                if(j > 0) { arr[i][j] += arr[i][j-1] % MOD_VALUE; }
            }
        }

        return arr[n - 1][m - 1] % MOD_VALUE;
    }
}
