package 백준.실버.문제_123더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 1,2,3 더하기 */
public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int value = Integer.parseInt(br.readLine());
            arr = new int[value+1];
            System.out.println(dp(value));
        }

    }

    private static int dp(int value) {
        if(value == 1) { return 1; }
        if(value == 2) { return 2; }
        if(value == 3) { return 4; }
        if(arr[value] != 0) { return arr[value]; }

        arr[value] = dp(value - 1) + dp(value - 2) +  dp(value - 3);

        return arr[value];
    }
}
