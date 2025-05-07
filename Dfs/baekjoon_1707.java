package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 이분 그래프
 * 기본 graph 값을 0으로 해두고 1의 값에서 한번, 그리고 -1의 값에서 한번 이분 그래프인지 확인을 하고
 * 이분 그래프가 아니라면 dfs 메소드에서 false를 return하여 "NO"를 출력하고 반대의 경우 "YES"를 출력한다.
 * 인접 행렬로 구현하게 되면 n*n으로 크기가 할당되어 메모리 초과가 발생하기 때문에 인접 리스트로 구현해야한다.
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
                    if(dfs(i, 1)) {
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
                if(dfs(val, -color)) return true;
            } else if(visited[val] == color) {
                return true;
            }
        }

        return false;
    }


}
