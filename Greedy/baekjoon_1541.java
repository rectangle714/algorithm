package Greedy;

import java.util.Scanner;

public class baekjoon_1541 {
    /* 잃어버린 괄호 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int result = 0;
        String[] split = line.split("-");

        for(int i=0; i<split.length; i++) {
            if(split[i].contains("+")) {
                int plusVal = 0;
                String[] split1 = split[i].split("\\+");
                for(String val : split[i].split("\\+")) {
                    plusVal += Integer.parseInt(val);
                }
                split[i] = plusVal+"";
            }

            if(i == 0) {
                result += Integer.parseInt(split[i]);
            } else {
                result -= Integer.parseInt(split[i]);
            }
        }

        System.out.println(result);
    }
}
