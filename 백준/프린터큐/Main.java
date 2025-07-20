package 백준.프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Doc> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(new Doc(i, importance));
            }



            int count = 1;
            boolean check = true;
            while(check) {
                List<Doc> list = new ArrayList<>(queue);
                int max = list.stream()
                        .max((o1, o2) -> Integer.compare(o1.importance, o2.importance))
                        .get().importance;

                Doc doc = queue.poll();

                if(doc.importance < max) {
                    queue.offer(doc);
                } else if(doc.index == m) {
                    check = false;
                    System.out.println(count);
                } else {
                    count++;
                }
            }

        }
    }
}

class Doc {
    public int index;
    public int importance;

    public Doc(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }
}
