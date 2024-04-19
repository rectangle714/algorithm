import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();

        int result = 0;
        if(list.size() == 1) {
            result = list.get(0);
        } else {
            for(int i=0; i<N; i++) {
                list.add(sc.nextInt());
            }

            Collections.sort(list);

            for(int i =0; i<list.size(); i++) {
                if(i == list.size()-1) {
                    result += list.get(i);
                } else {
                    result += Math.max(list.get(i) * list.get(i+1), list.get(i) + list.get(i+1));
                    i++;
                }
            }
        }

        System.out.println(result);
    }
}
