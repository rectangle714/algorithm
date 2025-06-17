package 백준.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long maxValue = 0;
        maxValue = Long.parseLong(br.readLine());

        long idx = 1;
        long sum = 0;
        long result = 0;
        while(true) {
            sum += idx;
            if(maxValue < sum) { break; }
            idx++;
        }
        result = idx-1;

        System.out.println(result);
    }
}
