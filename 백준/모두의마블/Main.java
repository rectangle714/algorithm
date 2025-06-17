package 백준.모두의마블;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 모두의 마블 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 카드의 갯수
        Integer[] l = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {                    // 카드의 갯수만큼 for문
            l[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(l, Comparator.reverseOrder());

        int result = 0;
        for(int i=1; i<n; i++) {
            result += l[0] + l[i];
        }

        System.out.println(result);
    }
}
