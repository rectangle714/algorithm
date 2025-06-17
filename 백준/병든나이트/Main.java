package 백준.병든나이트;

import java.util.Scanner;

public class Main {
    /* 병든 나이트 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                   // 세로 길이
        int M = sc.nextInt();                   // 가로 길이

        int moveCount = 0;

        if(N == 1) {
            moveCount = 1;
        } else if(N == 2) {
            moveCount = Math.min(4, (M+1) / 2);
        } else if(M < 7) {
            moveCount = Math.min(4, M);
        } else {
            moveCount = M - 2;
        }

        System.out.println(moveCount);

    }
}
