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

        // 모든 교점 계산
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = getPoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (point != null) {
                    pointList.add(point);
                }
            }
        }

        // 범위 찾기
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : pointList) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        // 2차원 배열 초기화 (빈 공간으로)
        char[][] starArr = new char[height][width];
        for (char[] row : starArr) {
            Arrays.fill(row, '.');
        }

        // 별 좌표 설정
        for (Point point : pointList) {
            int y = (int) (maxY - point.y);
            int x = (int) (point.x - minX);
            starArr[y][x] = '*';
        }

        // 결과 배열 변환
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(starArr[i]);
        }

        for(String val : answer) {
            System.out.println(val);
        }

    }

    // 교점 찾기
    public static Point getPoint(int a, int b, int c, int d, int e, int f) {
        int denominator = (a * e) - (b * d);    // 분모
        int numeratorX = (b * f) - (c * e);     // 분자 x
        int numeratorY = (c * d) - (a * f);     // 분자 y

        // 1. 분모 값이 0이면 두 직선이 평행이기 때문에 교점이 없으므로 null
        // 2. 정확히 나누어 떨어지는 경우만 반환
        if(denominator == 0 || numeratorX % denominator != 0 || numeratorY % denominator != 0) { return null; }

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
