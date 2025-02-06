package Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 포도주 시식 */
public class baekjoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wineArr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            wineArr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) { System.out.println(wineArr[1]); return; }
        dp[1] = wineArr[1];
        if(n == 2) { System.out.println(wineArr[1] + wineArr[2]); return; }
        dp[2] = wineArr[1] + wineArr[2];
        dp[3] = Math.max(dp[2], Math.max(wineArr[2] + wineArr[3], wineArr[1] + wineArr[3]));

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(wineArr[i] + wineArr[i-1] + dp[i-3], wineArr[i] + dp[i-2]));
        }

        System.out.println(dp[n]);
    }
}
