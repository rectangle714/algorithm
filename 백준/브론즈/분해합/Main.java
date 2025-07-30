package 백준.브론즈.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i=1; i<=N; i++) {
            int constructor = i;
            String toString = String.valueOf(i);
            for(int j=0; j<toString.length(); j++) {
                constructor += toString.charAt(j) - '0';
            }

            if(constructor == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
