package 백준.실버.랜선자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 랜선 자르기 */
public class Main {
    static int k, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long max = 0;
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(upperBound(arr, max));
    }

    private static long upperBound(int[] arr, long max) {
        long low = 0;
        long high = max + 1;     // low = 0, max = 0일 때를 대비해서 +1

        while(low < high) {
            long mid = (high + low) / 2;

            long count = 0;
            for(int i=0; i<arr.length; i++) {
                count += arr[i] / mid;
            }

            if(count < n) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low - 1;     // n을 초과한 길이에 -1 해줘야한다.
    }
}
