package 백준.콘센트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 콘센트 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] timeArr = new int[n];

        for(int i=0; i<n; i++) {
            timeArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeArr);

        PriorityQueue<Integer> flug = new PriorityQueue<>();
        int time = 0;

        for(int i=timeArr.length-1; i>=0; i--) {
            if(flug.size() == m) {
                time = flug.poll();
            }
            flug.add(time + timeArr[i]);
        }

        while(!flug.isEmpty()) {
            time = flug.poll();
        }

        System.out.println(time);
    }
}
