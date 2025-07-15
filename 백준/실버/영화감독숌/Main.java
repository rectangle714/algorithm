package 백준.실버.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 0;
        int count = 0;
        while(count != n) {
            if(String.valueOf(num).contains("666")) {
                count++;
            }

            num++;
        }

        System.out.println(num - 1);
    }
}
