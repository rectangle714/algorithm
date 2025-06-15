package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String p = br.readLine();                   // 수행할 함수
            int n = Integer.parseInt(br.readLine());    // 배열에 들어있는 수의 개수
            String line = br.readLine();
            int[] arr = Arrays.stream(line.substring(1, line.length() - 1).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 0; i < p.length(); i++) {

                if() {

                }

            }
        }
    }
}
