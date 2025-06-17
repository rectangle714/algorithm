package 백준.피보나치수5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 피보나치 수 5 (재귀) */
/* 시간복잡도 O(n^m) */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(callBack(n));
    }

    private static int callBack(int val) {
        if(val == 0) {
            return 0;
        } else if(val == 1) {
            return 1;
        } else {
            return callBack(val-1) + callBack(val-2);
        }
    }
}
