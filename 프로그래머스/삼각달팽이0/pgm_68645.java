package 프로그래머스.삼각달팽이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 삼각 달팽이 O(N²) */
public class pgm_68645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(br.readLine()));
    }

    public static int[] solution(int n) {
        int[] answer = new int[(n * (n+1) / 2)];
        int x = -1;
        int y = 0;
        int num = 1;
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i % 3 == 0) { x++; }
                if(i % 3 == 1) { y++;}
                if(i % 3 == 2) { x--; y--;}
                arr[x][y] = num++;
            }
        }

        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) break;
                answer[index++] = arr[i][j];
                System.out.print(arr[i][j]);
            }
        }

        return answer;
    }
}