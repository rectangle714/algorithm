package Etc;

import java.util.Arrays;

public class pgm_자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        int idx = 0;
        String value = String.valueOf(n);

        int[] answer = new int[value.length()];
        for(int i=value.length()-1; i>=0; i--) {
            answer[idx++] = Integer.parseInt(String.valueOf(value.charAt(i)));
        }
        return answer;
    }
}
