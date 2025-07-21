package 백준.실버.통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            sum += val;
            map.put(val, map.get(val) == null ? 0 : map.get(val) + 1);
        }

        // 산술평균
        System.out.println(Math.round((float) sum / n));

        Arrays.sort(arr);

        // 중앙값
        System.out.println(arr[n / 2]);

        // 최빈값
        int max = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        if(list.size() > 1) {
            System.out.println(list.get(1));
        } else if(list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(arr[1]);
        }

        // 범위
        System.out.println(arr[n - 1] - arr[0]);

    }
}
