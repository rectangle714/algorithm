package 백준.곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b));
    }

    private static long pow(long a, long b) {
        if(b == 1) {
            return a % c;
        }

        long val = pow(a, b / 2);

        // 모듈러 연산
        if(b % 2 == 1) return (val * val % c) * a % c;

        return val * val % c;
    }
}
