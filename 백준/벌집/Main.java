package 백준.벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(1);
        } else if(n >= 3) {
            System.out.println((n % 6) + 1);
        } else {
            System.out.println((n / 6) + 1);
        }
    }
}