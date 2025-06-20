package 백준.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        int[][] arr = new int[firstLine.length() + 1][secondLine.length() + 1];

        for(int i = 1; i <= firstLine.length(); i++) {
            for(int j = 1; j <= secondLine.length(); j++) {
                if(firstLine.charAt(i - 1) == secondLine.charAt(j - 1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        System.out.println(arr[firstLine.length()][secondLine.length()]);
    }
}
