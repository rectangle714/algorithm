package 백준.실버.과일탕후루;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 투포인터를 활용한 문제풀이 필요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
