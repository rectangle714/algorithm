package 백준.골드.NQUEEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] board;
    static int count;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int col) {
        if (col == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[col] = i;
            if (check(col)) {
                nQueen(col + 1);
            }
        }
    }

    public static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) {   // 같은 행일 때 false
                return false;
            }

            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {   // 대각선일 때 false
                return false;
            }
        }

        return true;
    }
}
