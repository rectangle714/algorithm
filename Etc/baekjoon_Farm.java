package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_Farm {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());       // 양 한마리 하루 사료 양
        int b = Integer.parseInt(st.nextToken());       // 염소 한마리 하루 사료 양
        int n = Integer.parseInt(st.nextToken());       // 양, 염소 전체 마릿수
        int w = Integer.parseInt(st.nextToken());       // 어제 하루 소비한 전체 사료 양

        // 양을 + 1 하면서 염소 숫자를 계산
        int[] result = new int[2];
        int count = 0;
        for(int i = 1; i < n; i++) {
            int sheep = i;
            int sheepFeed = i * a;
            int goat = n - i;
            int goatFeed = goat * b;

            if(sheepFeed + goatFeed - w == 0) {
                    count++;
                    result[0] = sheep;
                    result[1] = goat;
            }
        }

        if(count == 1) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println(-1);
        }
    }
}
