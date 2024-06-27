package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 이진수 */
public class baekjoon_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            while(true) {
                int val = n % 2;
                if(val == 1) { System.out.print(idx + " "); }
                n = n / 2;
                if(n == 0) { break; }
                idx++;
            }
        }
    }
}
