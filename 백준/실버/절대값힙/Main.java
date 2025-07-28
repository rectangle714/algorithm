package 백준.실버.절대값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Queue<Heap> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.abs == o2.abs) {
                return Integer.compare(o1.value, o2.value);
            } else {
                return Integer.compare(o1.abs, o2.abs);
            }
        });

        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.poll().value);
                } else {
                    System.out.println(0);
                }
            } else {
                queue.offer(new Heap(value, Math.abs(value)));
            }
        }

    }
}

class Heap {
    public int value;
    public int abs;

    public Heap(int value, int abs) {
        this.value = value;
        this.abs = abs;
    }
}

