package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2*n 타일링 2 */
public class baekjoon_11727 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        System.out.println(dp(n));
    }

    private static int dp(int value) {
        if(value == 1) return 1;
        if(value == 2) return 3;
        if(arr[value] != 0) return arr[value];

        arr[value] = (dp(value-1) + 2 * dp(value-2)) % 10007;

        return arr[value];
    }
}
