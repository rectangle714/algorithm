package 백준.골드.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       //
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int pow = (int)Math.pow(2, N);

        findIndex(0, 0, pow);
        System.out.println(count);
    }

    private static void findIndex(int row, int col, int size) {
        if(size == 1) {
            return;
        }

        int halfSize = size / 2;
        int blockSize = halfSize * halfSize;

        if(r < row + halfSize && c < col + halfSize) {          // 좌상
            findIndex(row, col, halfSize);
        } else if(r < row + halfSize && c >= col + halfSize) {   // 우상
            count += blockSize;
            findIndex(row, col + halfSize, halfSize);
        } else if(r >= row + halfSize && c < col + halfSize) {   // 좌하
            count += blockSize * 2;
            findIndex(row + halfSize, col, halfSize);
        } else {   // 우하
            count += blockSize * 3;
            findIndex(row + halfSize, col + halfSize, halfSize);
        }
    }
}
