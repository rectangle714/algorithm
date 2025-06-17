package 백준.구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());               // 수의 개수
        int m = Integer.parseInt(st.nextToken());               // 합을 구해야 하는 획수

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        // 반복문을 돌면서 arr 배열에 누적합 계산
        for(int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + val;
        }

        for(int i = 0; i < m; i++) {
            int result = 0;

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}
