package Dp;


import java.io.IOException;

/**
 * 정수 삼각형
 */
public class pgm_43105 {
    public static void main(String[] args) throws IOException {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        solution(triangle);
    }

    public static void solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[2];

        dp[0][0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++) {
            dp[i] = new int[triangle[i].length+1];
            for(int j=0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] += dp[i-1][0] + triangle[i][j];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int max = 0;
        for(int i=0; i<dp[triangle.length-1].length; i++) {
            max = Math.max(dp[triangle.length-1][i], max);
        }

        System.out.println(max);
    }
}
