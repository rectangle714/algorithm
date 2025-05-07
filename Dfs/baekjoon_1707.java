package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 이분 그래프
 */
public class baekjoon_1707 {
    static List<Integer>[] graph;
    static int[] visited;
    static int V, E = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 갯수 K
        int K = Integer.parseInt(br.readLine());

        while(0 < K--) {
            String line = br.readLine();
            V = Integer.parseInt(line.split(" ")[0]);       // 정점의 갯수
            E = Integer.parseInt(line.split(" ")[1]);       // 간선의 갯수

            graph = new ArrayList[V+1];
            visited = new int[V+1];

            for(int i=1; i<=V; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++) {
                line = br.readLine();
                int x = Integer.parseInt(line.split(" ")[0]);
                int y = Integer.parseInt(line.split(" ")[1]);

                graph[x].add(y);
                graph[y].add(x);
            }

            boolean isBipartite = true;
            for(int i=1; i<=V; i++) {
                if(visited[i] == 0) {
                    if(!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");

        }

    }

    private static boolean dfs(int node, int color) {
        visited[node] = color;

        for(int val : graph[node]) {
            if(visited[val] == 0) {
                if(!dfs(val, -color)) return false;
            } else if(visited[val] == color) {
                return false;
            }
        }

        return true;
    }


}
