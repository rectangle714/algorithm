package 백준.실버.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i + 1; j++) {
                if(j-1 < 0) {
                    arr[i][j] = arr[i][j] + arr[i-1][j];
                } else {
                    arr[i][j] = arr[i][j] + Math.max(arr[i-1][j], arr[i-1][j-1]);
                };
            }
        }

        System.out.println(Arrays.stream(arr[n-1]).max().getAsInt());
    }
}
