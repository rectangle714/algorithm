package 백준.회의실배정;

import java.util.Arrays;
import java.util.Scanner;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    /* 회의실 배정 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetingArr = new Meeting[N];

        int maxMeetingCount = 0;
        if(1<=N && N<=100000) {
            for(int i=0; i<N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                meetingArr[i] = new Meeting(start, end);
            }
        }
        Arrays.sort(meetingArr, (current, next) -> current.end == next.end? current.start - next.start : current.end - next.end );

        int val = 0;
        for(int i=0; i<N; i++) {
            if(val <= meetingArr[i].start) {
                val = meetingArr[i].end;
                maxMeetingCount++;
            }
        }
        System.out.println(maxMeetingCount);
    }
}
