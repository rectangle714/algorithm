package 백준.좌표정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 좌표 정렬하기 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointList.add(new Point(x, y));
        }

        pointList
                .sort((o1, o2) -> {
                    if(o1.x == o2.x) {
                        return Integer.compare(o1.y, o2.y);
                    } else {
                        return Integer.compare(o1.x, o2.x);
                    }
                });

        pointList.stream().forEach(point -> {
            System.out.println(point.x+ " " + point.y);
        });
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}