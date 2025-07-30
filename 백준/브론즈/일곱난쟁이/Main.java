package 백준.브론즈.일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 일곱 난쟁이 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int[] findArr = new int[2];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int inputValue = Integer.parseInt(br.readLine());
            arr[i] = inputValue;
            sum += inputValue;
        }

        Arrays.sort(arr);
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(i == j) { continue; }
                if(sum - (arr[i]+ arr[j]) == 100) {
                    findArr[0] = i;
                    findArr[1] = j;
                    break;
                }
            }
        }

        for(int i=0; i<9; i++) {
            if(i == findArr[0] || i == findArr[1]) {
                continue;
            }
            System.out.println(arr[i]);
        }

    }
}
