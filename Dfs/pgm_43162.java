package Dfs;


/**
 * 네트워크
 */
public class pgm_43162 {
    public static void main(String[] args) {
        int[][] computers = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1}
        };

        solution(5, computers);
    }

    static int[] visited;
    static int network = 0;
    private static void solution(int n, int[][] computers) {
        visited = new int[n];
        for(int i=0; i<n; i++) {
            if(visited[i] != 1) {
                dfs(i, computers);
                network++;
            }
        }
        System.out.println(network);
    }

    private static void dfs(int node, int[][] computers) {
        visited[node] = 1;

        for(int i=0; i<computers.length; i++) {
            if(visited[i] != 1 && computers[node][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
