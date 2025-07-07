package 백준.검증수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        for(int i = 0; i < 5; i++) {
            result += (long) Math.pow(Long.parseLong(st.nextToken()), 2);
        }

        System.out.println(result % 10);
    }
}
