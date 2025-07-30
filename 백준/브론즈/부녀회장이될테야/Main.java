package 백준.브론즈.부녀회장이될테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k + 1][n + 1];
            for(int j = 1; j <= n; j++) { arr[0][j] = j; }

            for(int j = 1; j <= k; j++) {
                for(int z = 1; z <= n; z++) {
                    arr[j][z] = arr[j - 1][z] + arr[j][z-1];
                }
            }
            System.out.println(arr[k][n]);
        }
    }
}
