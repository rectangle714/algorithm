package 백준.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 나무 자르기 */
public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 나무 갯수
        m = Integer.parseInt(st.nextToken());   // 나무 길이

        st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        System.out.println(upperBound(arr, max));
    }

    private static int upperBound(int[] arr, int max) {
        int low = 0;
        int high = max;

        while(low < high) {
            int mid = (low + high) / 2;

            long count = 0;
            for(int i=0; i<n; i++) {
                if(arr[i] - mid > 0) {
                    count += arr[i] - mid;
                }
            }

            if(count < m) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low - 1;
    }
}
