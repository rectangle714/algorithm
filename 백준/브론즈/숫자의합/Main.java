package 백준.브론즈.숫자의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += Integer.parseInt(String.valueOf(line.charAt(i)));
        }

        System.out.println(result);
    }
}
