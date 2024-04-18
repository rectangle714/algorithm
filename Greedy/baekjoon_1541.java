package Greedy;

import java.util.Scanner;

public class baekjoon_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int result = 0;
        int currentIdx = 0;
        String substring = "";
        for(int i=0; i<line.length(); i++) {
            if("+".equals(line.charAt(i)+"")) {
                substring = line.substring(currentIdx, i);
                result += Integer.parseInt(substring);
                currentIdx = i+1;
            }
            if( "-".equals(line.charAt(i)+"")) {
                substring = line.substring(currentIdx, i);
                result += Integer.parseInt(substring);
                currentIdx = i;
            }
            if(i == line.length()-1) {
                substring = line.substring(currentIdx, line.length());
                result += Integer.parseInt(substring);
            }
        }

        System.out.println(result);
    }
}
