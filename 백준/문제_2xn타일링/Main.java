package 백준.문제_2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(arr[n] != 0) return arr[n];
        arr[n] = (dp(n-2) + dp(n-1)) % 10007;
        return arr[n];
    }
}
