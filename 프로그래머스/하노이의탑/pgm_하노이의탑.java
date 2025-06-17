package 프로그래머스.하노이의탑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pgm_하노이의탑 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(solution(n)));
    }


    static List<int[]> list = new ArrayList<>();
    public static int[][] solution(int n) {
        move(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

    public static void move(int n, int from, int to, int via) {
        if(n == 1) {
            list.add(new int[]{from, to});
            return;
        }

        move(n - 1, from, via, to);
        list.add(new int[]{from, to});
        move(n - 1, via, to, from);
    }

}
