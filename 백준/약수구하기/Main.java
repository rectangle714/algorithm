package 백준.약수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 약수 구하기 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = 0;

        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++) {
            if(n % i == 0) {
                arr[index++] = i;
            }
        }

        System.out.println(arr[k-1]);
    }
}
