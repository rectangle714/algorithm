package 백준.실버.파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 1];

            // n이 4보다 작으면 1 출력
            if(n < 4) {
                System.out.println(1);
                continue;
            }

            // n이 3까지는 값 1으로 입력
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for(int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            System.out.println(dp[n]);
        }
    }
}
