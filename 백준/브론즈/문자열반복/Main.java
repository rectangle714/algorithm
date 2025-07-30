package 백준.브론즈.문자열반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++) {
                for(int z = 0; z < r; z++) {
                    sb.append(s.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
