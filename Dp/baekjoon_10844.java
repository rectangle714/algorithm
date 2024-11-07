package Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 쉬운 계단 수 */
public class baekjoon_10844 {
    static long DIVIDE_VALUE = 1000000000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        long result = 0;

        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j - 1 >= 0) {
                    dp[i][j] += dp[i-1][j-1];
                }

                if(j + 1 <= 9) {
                    dp[i][j] += dp[i-1][j+1];
                }

                dp[i][j] %= DIVIDE_VALUE;
            }
        }

        for(int i=0; i<=9; i++) {
            result += dp[N][i];
        }

        System.out.println(result % DIVIDE_VALUE);
    }
}
