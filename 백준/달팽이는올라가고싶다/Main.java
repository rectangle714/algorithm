package 백준.달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());       // 올라가는 길이
        int b = Integer.parseInt(st.nextToken());       // 내려가는 길이
        int v = Integer.parseInt(st.nextToken());       // 최종 높이

        // 올라가야할 높이 / 하루 오르는 높이
        int day = (v - b) / (a - b);

        // 나머지가 존재하면 하루 +1을 해줘야함
        if((v - b) % (a - b) != 0) { day++; }

        System.out.println(day);
    }
}
