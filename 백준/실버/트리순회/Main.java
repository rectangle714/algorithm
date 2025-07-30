package 백준.실버.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, String[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 트리 노드의 갯수

        while(N-- > 0) {
            String[] split = br.readLine().split(" ");
            String parent = split[0];
            String left = split[1];
            String right = split[2];

            map.put(parent, new String[]{left, right});
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    // 전위 순회
    public static void preOrder(String val) {
        if(".".equals(val)) return;
        System.out.print(val);
        preOrder(map.get(val)[0]);
        preOrder(map.get(val)[1]);
    }

    // 중위 순회
    public static void inOrder(String val) {
        if(".".equals(val)) return;
        inOrder(map.get(val)[0]);
        System.out.print(val);
        inOrder(map.get(val)[1]);
    }

    // 후위 순회
    public static void postOrder(String val) {
        if(".".equals(val)) return;
        postOrder(map.get(val)[0]);
        postOrder(map.get(val)[1]);
        System.out.print(val);
    }
}
