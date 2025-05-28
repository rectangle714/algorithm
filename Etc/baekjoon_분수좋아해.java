package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 분수 좋아해? */
public class baekjoon_분수좋아해 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0) break;

            int divide = x / y;
            int remain = x % y;

            System.out.println(divide + " " + remain + " / " + y);
        }
    }
}
