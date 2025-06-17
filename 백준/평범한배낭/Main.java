package 백준.평범한배낭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 평범한 배낭 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            arr[i][0] = W;
            arr[i][1] = V;
        }

        for(int i=1; i<=N; i++) {
            int weight = arr[i][0];     // 무게
            int value = arr[i][1];      // 가치
            for (int j = 0; j <= K; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
