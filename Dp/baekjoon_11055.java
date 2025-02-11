package Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 가장 큰 증가하는 부분 수열 */
public class baekjoon_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = dp[0];
        for(int i=0; i<A; i++) {
            dp[i] = arr[i];
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}
