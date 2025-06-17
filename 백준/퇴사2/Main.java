package 백준.퇴사2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 퇴사 2 */
public class Main {
    static StringTokenizer st;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];
        dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 상담 시간
            arr[i][1] = Integer.parseInt(st.nextToken());   // 상담 비용
        }

        for(int i = 1; i <= n; i++) {
            int time = arr[i][0];
            int price = arr[i][1];

            if(i + time - 1 <= n) {
                dp[i + time-1] = Math.max(dp[i + time-1], dp[i - 1] + price);
            }

            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}
