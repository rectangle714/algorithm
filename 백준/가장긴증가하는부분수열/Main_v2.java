package 백준.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열 (DP) 2번째 방식 */
public class Main_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        int[] dp = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 1; i < a; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {  // 증가하는 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]); // 최댓값 갱신
        }

        System.out.println(result);
    }
}
