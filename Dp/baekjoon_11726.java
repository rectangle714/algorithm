package Dp;

import java.util.Scanner;

public class baekjoon_11726 {
    public static int[] arr;
    public static void main(String[] args) {
        int a = 0;
        int total = 0;
        Scanner inputA = new Scanner(System.in);
        int num = inputA.nextInt();
        arr = new int[num + 1];
        System.out.println(dp(num) % 100007);
    }

    private static int dp(int input) {
        if(input == 1) { return 1; }
        if(input == 2 ) { return 2; }
        if(arr[input] != 0) { return arr[input]; }
        arr[input] = (dp(input - 1) + dp(input - 2)) % 10007;
        return arr[input];
    }
}
