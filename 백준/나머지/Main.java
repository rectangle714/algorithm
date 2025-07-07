package 백준.나머지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            int val = Integer.parseInt(br.readLine());
            map.put(val % 42, map.get(val % 42) == null ? 1 : map.get(val % 42) + 1 );
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if(entry.getValue() >= 1) {
               result++;
           }
        }

        System.out.println(result);
    }
}
