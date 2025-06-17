package 백준.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st;
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else{
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        System.out.println(1);
                    } else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.getLast());
                    }
                    break;
            }
        }
    }
}
