package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* A -> B */
public class baekjoon_16953 {

    static long a, b;
    static long result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        long count = 1;
        dfs(a, count);

        if (result != -1) {
            System.out.println(result-1);
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(long value, long count) {
        count++;
        if(value == b) { result = count; }
        if(value > b) {
            return;
        }

        dfs(value * 2, count);
        dfs(Long.parseLong(value+"1"), count);
    }
}
