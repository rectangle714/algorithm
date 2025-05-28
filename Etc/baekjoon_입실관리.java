package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_입실관리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            System.out.println(br.readLine().toLowerCase());
        }
    }
}
