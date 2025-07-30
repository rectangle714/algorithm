package 백준.브론즈.알파벳찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for(int i = 'a'; i <= 'z'; i++) {
            int index = -1;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == i) {
                    index = j;
                    break;
                }
            }

            sb.append(index).append(" ");
        }

        System.out.println(sb);
    }
}
