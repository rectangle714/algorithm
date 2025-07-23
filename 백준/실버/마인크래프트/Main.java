package 백준.실버.마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 세로 길이
        int m = Integer.parseInt(st.nextToken());       // 가로 길이
        int b = Integer.parseInt(st.nextToken());       // 블록 갯수

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
            }
        }

        int minTime = Integer.MAX_VALUE;        // 최소 시간
        int height = 0;                   //
        for(int x = 0; x <= 256; x++) {
            int block = 0;
            int time = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] > x) {
                        block -= x - arr[i][j];
                        time += (arr[i][j] - x) * 2;
                    } else {
                        block += arr[i][j] - x;
                        time -= arr[i][j] - x;
                    }
                }
            }

            // 입력받은 블록 갯수와 사용되는 블록 갯수가 음수가 되면 안됨
            if(b + block >= 0) {
                if(time < minTime) {
                    minTime = time;
                    height = x;
                } else if(time == minTime) {
                    minTime = time;
                    height = Math.max(x, height);
                }
            }
        }

        // 시간 + 땅 높이 출력
        System.out.println(minTime + " " + height);
    }
}
