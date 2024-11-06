package Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 퇴사 */
public class baekjoon_14501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        int[] dp = new int[N+2];

        StringTokenizer st;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i > 0; i--) {
            int t = arr[i][0];
            int p = arr[i][1];

            if(i + t <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[i+t] + p);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
