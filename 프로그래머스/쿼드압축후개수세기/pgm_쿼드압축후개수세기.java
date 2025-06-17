package 프로그래머스.쿼드압축후개수세기;

import java.util.Arrays;

public class pgm_쿼드압축후개수세기 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        };
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int countZero, countOne;
    public static int[] solution(int[][] arr) {
        int[] answer = {};
        recursion(0,0, arr, arr.length);

        return new int[]{countZero, countOne};
    }

    public static void recursion(int y, int x, int[][] arr, int size) {
        int val = arr[y][x];

        boolean isEquals = true;
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(val != arr[i][j]) {
                    isEquals = false;
                    break;
                }
            }
            if(!isEquals) break;
        }

        if(isEquals) {
            if(val == 0) {
                countZero++;
            } else {
                countOne++;
            }
            return;
        }

        int half = size / 2;
        recursion(y, x, arr, half); // 좌상
        recursion(y, x + half, arr, half); // 우상
        recursion(y + half, x, arr, half); // 좌하
        recursion(y + half, x + half, arr, half); // 우하
    }
}
