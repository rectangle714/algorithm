package 백준.실버.단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   // 단어의 개수
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);            // 사전 순 정렬
            } else {
                return o1.length() - o2.length();   // 길이에 따라 정렬
            }
        }));

        System.out.println(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(!arr[i].equals(arr[i-1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
