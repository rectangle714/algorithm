package 백준.골드.뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr = new int[101];
    static int[] dist = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, -1);

        // 사다리 정보 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }
        
        // 뱀 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        Queue<Integer> queue = new LinkedList<>();
        dist[1] = 0;
        queue.offer(1);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current == 100) {
                System.out.println(dist[100]);
                return;
            }

            for(int i = 1; i <= 6; i++) {
                int next = current + i;
                if(next > 100) continue;

                if(arr[next] != 0) {
                    next = arr[next];
                }

                if(dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
