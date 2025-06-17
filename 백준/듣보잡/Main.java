package 백준.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken());       // 보도 못한 사람 수

        Set<String> set = new LinkedHashSet<>();
        while(N-- > 0) {
            set.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        while(M-- > 0) {
            String value = br.readLine();
            if(set.contains(value)) {
                result.add(value);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(String val : result) {
            System.out.println(val);
        }
    }
}
