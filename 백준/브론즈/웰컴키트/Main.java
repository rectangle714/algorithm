package 백준.브론즈.웰컴키트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 참가자 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());       // 티셔츠 묶음 수
        int p = Integer.parseInt(st.nextToken());       // 펜 묶음 수

        int tCount = 0;
        for(int i = 0; i < 6; i++) {
            if(arr[i] % t != 0) {
                tCount += arr[i] / t + 1;
            } else {
                tCount += arr[i] / t;
            }
        }

        System.out.println(tCount);
        System.out.println(n / p + " " + n % p);
        
    }
}
