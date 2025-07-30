package 백준.골드.강의실배정;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture {
    int start;
    int end;
    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    /* 강의실 배정 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Lecture[] lectures = new Lecture[N];
        for(int i=0; i<N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (first, second) -> first.start == second.start ? first.end - second.end : first.start - second.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }

        System.out.println(pq.size());
    }
}
