package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_10610 {

    /* 30 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] arr = new int[N.length()];

        int total = 0;
        for(int i=0; i<arr.length; i++){
            total += N.charAt(i);
        }
        if(!N.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        char[] charArr = N.toCharArray();
        Arrays.sort(charArr);
        StringBuilder strBuilder = new StringBuilder();
        for(int i=charArr.length-1; i>=0; i--) {
            strBuilder.append(charArr[i]);
        }
        System.out.println(strBuilder.toString());
    }
}
