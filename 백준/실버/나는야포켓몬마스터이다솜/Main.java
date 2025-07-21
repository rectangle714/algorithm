package 백준.실버.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, String.valueOf(i));
            map.put(String.valueOf(i), name);
        }

        for(int i = 0; i < m; i++) {
            String val = br.readLine();
            System.out.println(map.get(val));
        }
    }
}
