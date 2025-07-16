package 백준.실버.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][m];
        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                int countW = 0;
                int countB = 0;

                for(int x = i; x < i + 8; x++) {
                    for(int y = j; y < j + 8; y++) {
                        if((x+y) % 2 == 0) { // 짝수일때
                            if(!arr[x][y].equals("B")) countB++;
                            if(!arr[x][y].equals("W")) countW++;
                        } else {    // 홀수일때
                            if(!arr[x][y].equals("B")) countW++;
                            if(!arr[x][y].equals("W")) countB++;
                        }
                    }
                }

                minCount = Math.min(minCount, Math.min(countW, countB));
            }
        }

        System.out.println(minCount);
    }
}
