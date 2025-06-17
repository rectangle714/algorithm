package 백준.대회or인턴;

import java.util.Scanner;

public class baekjoon_2875 {

    /* 대회 or 인턴 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 여학생 수
        int M = sc.nextInt();   // 남학생 수
        int K = sc.nextInt();   // 인턴쉽 수

        int count = 0;
        int teamCount = 0;

        while(N >= 2 && M > 0 && (N+M) >= K + 3) {
            N = N - 2;
            M = M - 1;
            teamCount++;
        }

        System.out.println(teamCount);
    }
}
