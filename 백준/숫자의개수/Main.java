package 백준.숫자의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String multi = (a * b * c) + "";
        int[] arr = new int[10];
        for(int i = 0; i < multi.length(); i++) {
            int val = Integer.parseInt(multi.charAt(i) + "");
            arr[val] += 1;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
