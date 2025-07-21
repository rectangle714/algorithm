package 백준.실버.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            System.out.println(arr[1]);
            return;
        }

        if(n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        // 첫번째 계단 밟았을 때
        dp[1] = arr[1];
        // 첫번째 + 두번째 계단 밟았을 때
        dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= n; i++) {
            // 1.두번째 전꺼 밟고 왔을때
            // 2.세번째 전 계단에서 이전 계단 밟고 왔을 때
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        System.out.println(dp[n]);

    }
}
