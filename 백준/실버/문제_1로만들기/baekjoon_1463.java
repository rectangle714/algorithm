package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1로 만들기 (Bottom-Up) */
public class baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;    // 1을 뺄 때

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2 나누어 떨어질 때
            } else if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3 나누어 떨어질 때
            }
        }

        System.out.println(dp[n]);
    }
}
