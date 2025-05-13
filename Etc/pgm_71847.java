package Etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 교점에 별 만들기
 */
public class pgm_71847 {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        List<Point> pointList = new ArrayList<>();

        for(int i=0; i<line.length-1; i++) {
            for(int j = i+1; j<line.length; j++) {
                Point point = getPoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(null != point) {
                    pointList.add(point);
                }
            }
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(Point point : pointList) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.x);
            maxY = Math.max(maxY, point.x);
        }

        // 배열 생성
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;

        String[][] starArr = new String[height][width];

        for(int i=0; i< height; i++) {
            Arrays.fill(starArr[i], ".");
        }


        for(Point point : pointList) {
            int row = maxY - point.y;
            int col = point.x - minX;
            starArr[row][col] = "*";
        }

        for(String[] row : starArr) {
            System.out.println(row);
        }
    }

    // 교점 찾기
    public static Point getPoint(int a, int b, int c, int d, int e, int f) {
        int denominator = (a * d) - (b * c);    // 분모
        int numeratorX = (b * f) - (e * d);     // 분자 x
        int numeratorY = (e * c) - (a * f);     // 분자 y

        // 1. 분모 값이 0이면 두 직선이 평행이기 때문에 교점이 없으므로 null
        // 2. 정확히 나누어 떨어지는 경우만 반환
        if(((a * d) - (b * c)) == 0 || numeratorX % denominator != 0 || numeratorY % denominator != 0) { return null; }

        int x = numeratorX / denominator;
        int y = numeratorY / denominator;

        return new Point(x, y);
    }
}

//class Point {
//    int x;
//    int y;
//
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
