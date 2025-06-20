package 백준.N과M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        backtracking(2, 0);

        System.out.println(sb);
    }

    private static void backtracking(int val, int depth) {
        if(m == depth) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = val - 1; i <= n; i++) {
            arr[depth] = i;
            backtracking(i + 1, depth + 1);
        }
    }

}
