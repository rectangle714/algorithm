package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 서강근육맨
 * 각 근손실 정도의 합을 구해서 최대 근손실 값을 최소화하는 문제
 * 근손실 정도 배열값을 오름차순으로 정리 후 배열 값의 순서대로
 * 작은 값 + 큰 값을 구해서 그 중 최대 값을 return 해주면 해결된다.
 */
public class baekjoon_20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());                    // 운동기구 개수 N
        long[] T = new long[N];                                     // 근손실 정도 t
        long M = -1;                                                  // 최소 근손실 정도

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            T[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(T);

        // 1. 짝수 일때는 최소 + 최대 값 중 최대 값
        // 2. 홀수 일때는 마지막 값을 보류 후 최소 + 최대 값을 구하고 마지막 값과 비교
        if(N % 2 == 0) {
            for(int i=0; i<N; i++) {
                M = Math.max(M, T[i] + T[N - 1 - i]);
            }
        } else {
            for(int i=0; i<N-1; i++) {
                M = Math.max(M, T[i] + T[N - 2 - i]);
            }
            M = Math.max(M, T[N-1]);
        }

        System.out.println(M);
    }
}
