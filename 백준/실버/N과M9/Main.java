package 백준.실버.N과M9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth) {
        // M 호출하면 return;
        if(depth == M) {
            for(int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");

            return;
        }

        int before = 0;
        for(int i = 0; i < N; i++) {
            // 방문했던 index 이거나 이전 값이 동일하면 continue
            if(visited[i] || before == arr[i]) continue;

            visited[i] = true;
            result[depth] = arr[i];
            before = arr[i];
            dfs(depth + 1);

            visited[i] = false;
        }
    }
}
