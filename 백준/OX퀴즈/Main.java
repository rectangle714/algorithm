package 백준.OX퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            int[] arr = new int[s.length() + 1];

            for(int j = 1; j < s.length() + 1; j++) {
                if("O".equals(s.charAt(j - 1)+"")) {
                    arr[j] = arr[j - 1] + 1;
                } else {
                    arr[j] = 0;
                }
            }

            System.out.println(Arrays.stream(arr).sum());
        }
    }
}
