package 백준.브론즈.알람시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m - 45 < 0) {
            h = h - 1;
            if(h < 0) {
                h = 23;
            }
            m = 60 + (m - 45);
        } else {
            m = m - 45;
        }

        System.out.println(h + " " + m);
    }
}
