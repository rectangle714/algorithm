package 백준.브론즈.지능형기차2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 지능형 기차 2 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int outSum = 0;
        int inSum = 0;
        int[] resultArr = new int[10];
        for(int i = 0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            outSum += Integer.parseInt(st.nextToken());
            inSum += Integer.parseInt(st.nextToken());
            resultArr[i] = inSum - outSum;
        }

        Arrays.sort(resultArr);
        System.out.println(resultArr[9]);

    }
}
