package 백준.실버.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// "에라토스테네스의 체"를 활용하여 문제를 풀어야 시간 내에 문제 해결 가능
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[m + 1];
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(m); i++) {
            for(int j = i * i; j <= m; j += i) {
                if(!arr[j]) {
                    arr[j] = true;
                }
            }
        }

        for(int i = n; i <= m; i++) {
            if(!arr[i]) {
                System.out.println(i);
            }
        }
    }
}
