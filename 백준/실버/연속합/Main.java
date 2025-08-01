package 백준.실버.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연속합 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxVal = arr[1];
        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.println(maxVal);
    }
}
