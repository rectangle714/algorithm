package 백준.집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> set = new HashSet<Integer>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String stringVal = st.nextToken();
            if(stringVal.equals("all")) {
                for(int j=1; j<=20; j++) {
                    set.add(j);
                }
            } else if(stringVal.equals("empty")) {
                set = new HashSet<>();
            } else {
                int intVal = Integer.parseInt(st.nextToken());
                execute(stringVal, intVal);
            }
        }
        System.out.print(sb.toString());
    }

    public static void execute(String stringVal, int intVal) {
        switch (stringVal) {
            case "add":
                set.add(intVal);
                break;
            case "check":
                if(set.contains(intVal)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                break;
            case "remove":
                set.remove(intVal);
                break;
            case "toggle":
                if(set.contains(intVal)) {
                    set.remove(intVal);
                } else {
                    set.add(intVal);
                }
                break;
        }
    }
}
