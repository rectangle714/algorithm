package 백준.색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 색종이 만들기 (분할정복) */
/* 시간복잡도 O(n^2 log n) */
public class Main {
    static int white, blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void recursive(int col, int row, int size) {
        if(check(col, row, size)) {
            if(arr[col][row] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 2;
        recursive(col, row, newSize);						        // 2사분면
        recursive(col, row + newSize, newSize);				// 1사분면
        recursive(col + newSize, row, newSize);				    // 3사분면
        recursive(col + newSize, row + newSize, newSize);	// 4사분면
    }

    private static boolean check(int col, int row, int size) {
        int color = arr[col][row];

        for(int i=col; i<col + size; i++) {
            for(int j=row; j<row + size; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

}
