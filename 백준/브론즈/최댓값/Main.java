package 백준.브론즈.최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int index = 0;
        int count = 0;
        for(int val : arr) {
            count++;
            if(val > max) {
                max = val;
                index = count;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
