package 백준.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 좌표 압축 (정력) */
/* 시간복잡도 O(n) */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[n];
        int[] sortArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            sortArr[i] = value;
        }

        Arrays.sort(sortArr);

        int rank = -1;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(sortArr[i])) { rank++; }
            map.put(sortArr[i], rank);
        }

        // 시간 초과 해결을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
