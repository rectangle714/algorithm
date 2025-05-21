package Etc;

import java.util.Arrays;

public class pgm_하노이의탑 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(solution(n)));
    }

    static int[][] answer = {};
    public static int[][] solution(int n) {
        answer = new int[n + n - 1][2];
        if(n == 1) return new int[][]{{1,3}};
        recursion(n - 1, 2);
        answer[count + 1][0] = 1;
        answer[count + 1][1] = 3;
        recursion(count, 3);

        return answer;
    }

    static int count = 0;
    public static void recursion(int n, int move) {
        int x = 0;
        int y = 0;

        if(move == 2) {
            x = 1;
            y = 2;
        } else if(move == 3) {
            x = 2;
            y = 3;
        }

        for(int i = count++; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    answer[i][j] = x;
                } else {
                    answer[i][j] = y;
                }
            }
        }

    }

}
