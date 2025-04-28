package Etc;

import java.util.Arrays;

/**
 * 최고의 집합
 * 숫자들이 비슷해야 곱이 가장 크기 때문에 비슷한 숫자들을 구하고 나머지 만큼 +1 해주면 가장 큰 값이 나온다.
 */
public class pgm_12938 {
    public static void main(String[] args) {
        int n = 2, s = 9;
        solution(n, s);
    }

    private static int[] solution(int n, int s) {
        // 1. 최고의 집합이 존재하지 않는 경우
        if(n > s) return new int[] {-1};

        int[] result = new int[n];

        // 2. 비슷한 숫자들을 구하기 위해 s 값을 n으로 나눔
        int val = s/n;
        for(int i=0; i<n; i++) {
            result[i] = val;
        }

        // 3. 나머지를 구해서 나머지 크기 만큼 구한 값들에 +1을 해줌
        int remain = s%n;
        for(int i=0; i<remain; i++) {
            result[i] = result[i] + 1;
        }

        // 4. 오름차순으로 정렬
        Arrays.sort(result);

        return result;
    }
}
