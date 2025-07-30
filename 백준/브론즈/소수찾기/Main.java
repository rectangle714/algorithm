package 백준.브론즈.소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수 찾기 */
/* 시간복잡도 O(n*m) */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            boolean check = false;

            if(value == 1) { continue; }

            for(int j=2; j<value; j++) {
                if(value % j == 0) {
                    check = true;
                }
            }

            if(!check) {
                count++;
            }
        }
        System.out.println(count);
    }
}
