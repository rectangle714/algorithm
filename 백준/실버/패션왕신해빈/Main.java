package 백준.실버.패션왕신해빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());        // 테스트 케이스

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());    // 의상 수

            // {옷 종류, 갯수} 형식으로 map에 각각 담아준다
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                String type = br.readLine().split(" ")[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int count = 1;
            
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                count *= (entry.getValue() + 1);    // 안입었을 때가 있기 때문에 value에 +1한 값을 count에 곱해준다. 
            }

            System.out.println(--count);            // 마지막으로 아무것도 안입은 경우를 위해 -1 처리 후 출력
        }
    }
}