package 백준.나무탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int count;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> nodeList;
    /* 나무 탈출 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];

        nodeList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            nodeList.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList.get(a).add(b);
            nodeList.get(b).add(a);
        }

        dfs(1, 0);
        if(count % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static void dfs(int node, int depth) {
        visit[node] = true;

        for(int next : nodeList.get(node)) {
            if(!visit[next]) {
                dfs(next, depth+1);
            }
        }

        if(1 != node && nodeList.get(node).size() == 1) {
            count += depth;
        }
    }

}
