package 백준.실버.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 촌수계산 */
public class Main {

    static int n;   // 전체 사람의 수
    static int m;   // 부모 자식 간의 관계의 개수
    static int[][] map; // 부모 자식 간의 관계 Array
    static int a, b;    // 서로 다른 두사람의 번호 a, b
    static int[] deep;  // 촌수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        deep = new int[n+1];

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());  // y의 부모 번호
            int y = Integer.parseInt(st.nextToken());  // 자식 번호

            map[x][y] = 1;
            map[y][x] = 1;
        }

        bfs(a); // 시작 값 bfs 시작

        // 마지막 번호의 배열 값이 0이면 -1 아니면 마지막 번호 배열의 값
        if(deep[b] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(deep[b]);
        }

    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            if(currentNode == b) { break; }

            for(int i=1; i<=n; i++) {
                if(map[currentNode][i] ==1 && deep[i] == 0) {
                    queue.offer(i);
                    deep[i] = deep[currentNode]+1;
                }
            }
        }
    }

}
