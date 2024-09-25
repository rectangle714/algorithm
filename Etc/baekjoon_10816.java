package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 숫자카드 2 */
public class baekjoon_10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arrayN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arrayN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayN);

        int m = Integer.parseInt(br.readLine());
        int[] arrayM = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arrayM[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            int count = 0;
            int firstIdx = getFirstIdx(arrayN, arrayM[i]);
            int lastIdx = getLastIdx(arrayN, arrayM[i]);

            sb.append(lastIdx-firstIdx).append(" ");
        }

        System.out.print(sb.toString());
    }

    private static int getFirstIdx(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= target) {
                high = mid;
            } else {
                low = ++mid;
            }
        }

        return low;
    }

    private static int getLastIdx(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) {
                high = mid;
            } else {
                low = ++mid;
            }
        }

        return low;
    }
}
