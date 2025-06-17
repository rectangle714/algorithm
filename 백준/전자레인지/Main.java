package 백준.전자레인지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전자레인지
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        if(T % 10 != 0 ) { System.out.print(-1); return; }

        // 버튼 A, B, C 세팅
        int[] button = new int[]{300, 60, 10};

        // 큰 수부터 차례대로 나머지를 구함
        for(int i=0; i<3; i++) {
            int val = T / button[i];
            System.out.print(val + " ");
            T = T - button[i] * val;
        }
    }
}
