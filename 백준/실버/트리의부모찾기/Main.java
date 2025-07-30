package 백준.실버.트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 트리의 부모 찾기 */
public class Main {

    static int N;
    static boolean[] visited;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parents = new int[N+1];

        list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);

        for(int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void bfs(int idx) {
        visited[idx] = true;

        for(int val  : list.get(idx)) {
            if(!visited[val]) {
                parents[val] = idx;
                bfs(val);
            }
        }
    }

}
