package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 최댓값과 최솟값 */
public class pgm_12939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(String.valueOf(Integer.parseInt(br.readLine())));
    }

    public static String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int[] intNumbers = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        answer = Arrays.stream(intNumbers).min().getAsInt() + " " + Arrays.stream(intNumbers).max().getAsInt();

        return answer;
    }
}
