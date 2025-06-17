package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1로 만들기 (Top-Down) */
public class baekjoon_1463v2 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        minOperation(n);

        System.out.println(dp[n]);
    }

    private static int minOperation(int x) {
        if(x == 1) {
            return 0;
        }

        if(dp[x] != 0) {
            return dp[x];
        }

        int minValue = minOperation(x - 1) + 1;

        if(x % 2 == 0) {
            minValue = Math.min(minValue, minOperation(x / 2) + 1);
        } else if(x % 3 == 0) {
            minValue = Math.min(minValue, minOperation(x / 3) + 1);
        }

        dp[x] = minValue;

        return minValue;
    }
}
