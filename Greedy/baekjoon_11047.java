package Greedy;

import java.io.IOException;
import java.util.Scanner;

public class baekjoon_11047 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];

        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int result = 0;
        for(int i = coin.length-1; i>=0; i--) {
            if (k >= 0) {
                result +=  k / coin[i];
                k = k % coin[i];
            } else {
                break;
            }
        }
        System.out.println(result);
    }

}
