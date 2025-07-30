package 백준.브론즈.ACM호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 층 수
            int w = Integer.parseInt(st.nextToken()); // 가로방 수 (사용 안함)
            int n = Integer.parseInt(st.nextToken()); // 손님 번호

            int y = n % h;
            int x = n / h + 1;

            if (y == 0) {
                y = h;
                x -= 1;
            }

            System.out.printf("%d%02d\n", y, x);  // 두 자리수 보장
        }
    }
}

