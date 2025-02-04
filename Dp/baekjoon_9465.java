package Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 스티커 */
public class baekjoon_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickerArr = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=1; k<=n; k++) {
                    stickerArr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickerArr[0][1];
            dp[1][1] = stickerArr[1][1];

            for(int j=2; j<=n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickerArr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickerArr[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }
    }
}
