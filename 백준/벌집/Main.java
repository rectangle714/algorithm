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
            return;
        }

        int val = 7;
        int count = 2;
        while(n > val) {
            val += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}