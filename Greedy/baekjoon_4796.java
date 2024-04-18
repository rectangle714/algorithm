package Greedy;

import java.util.Scanner;

public class baekjoon_4796 {
    /* 캠핑 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = 1;

        while(true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            int result = 0;

            if(L == 0 && P == 0 && V == 0) { break; }

            int a = (V / P) * L;
            int b = Math.min((V - (V / P) * P), L);
            result += (a + b);
            System.out.printf("Case %d: %d \n", caseCount, result);
            caseCount++;
        }
    }
}
