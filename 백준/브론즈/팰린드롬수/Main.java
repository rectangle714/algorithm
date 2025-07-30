package 백준.브론즈.팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) {
                break;
            }

            String result = "yes";
            for(int i = 0; i < s.length() / 2; i++) {
                if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    result = "no";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
