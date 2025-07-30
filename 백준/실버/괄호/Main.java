package 백준.실버.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String line = br.readLine();

            if(line.charAt(0) == ')') {
                System.out.println("NO");
            } else {
                int left = 0;
                int right = 0;

                for(int j=0; j<line.length(); j++) {
                    if(line.charAt(j) == '(') {
                        left++;
                    } else if(line.charAt(j) == ')') {
                        right++;
                    }

                    if(right > left) break;
                }

                if(left == right) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
