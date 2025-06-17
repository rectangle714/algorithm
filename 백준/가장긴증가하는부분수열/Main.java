package 백준.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열 (DP) */
/* 시간 복잡도 O(n^2) */
public class Main {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
                    dp[i]++;
                }
            }
        }

//        int maxValue = 0;
//        for(int i=0; i<n; i++) {
//            maxValue = Math.max(maxValue, dp[i]);
//        }
//
//        System.out.println(maxValue);

        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}
