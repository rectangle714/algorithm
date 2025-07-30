package 백준.실버.ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /* ATM */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        int result = 0;

        for(int i=0; i<N; i++) {
            P[i] = sc.nextInt();
        }

        int sum = 0;
        int exVal = 0;

        Arrays.sort(P);
        for(int i=0; i<N; i++) {
            sum += exVal+P[i];
            exVal = exVal+P[i];
            result = sum;
        }

        System.out.println(result);
    }
}
