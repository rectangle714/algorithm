package 백준.실버.로프;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    /* 로프 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] K = new Integer[N];

        for(int i=0; i<N; i++) {
            K[i] = sc.nextInt();
        }
        Arrays.sort(K, Comparator.reverseOrder());

        for(int i=0; i<N; i++) {
            K[i] = K[i] * (i+1);
        }

        int result = Arrays.stream(K).max(Comparator.comparingInt(o -> o)).get().intValue();
        System.out.println(result);
    }
}
