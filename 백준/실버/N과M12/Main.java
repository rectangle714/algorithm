package 백준.실버.N과M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int index, int depth) {
        if(m == depth) {
            for(int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");

            return;
        }

        int prev = 0;
        for(int i = index; i < n; i++) {
            if(prev != arr[i]) {
                result[depth] = arr[i];
                prev = arr[i];

                dfs(i, depth + 1);
            }
        }
    }
}
