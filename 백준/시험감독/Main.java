package 백준.시험감독;

import java.util.Scanner;

public class Main {
    /* 시험 감독 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N+1];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();
        long result = 0;

        for(int i=0; i<N; i++) {
            // 총 감독관 최소 1명
            A[i] = A[i] - B;
            result++;

            if(A[i] > 0) {
                result += A[i] / C;
                if(A[i] % C != 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
