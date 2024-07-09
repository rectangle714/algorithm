package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 블랙잭 */
public class baekjoon_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int difference = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;

            for(int j=i+1; j<n; j++) {

                for(int k=j+1; k<n; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum > m) {
                        continue;
                    } else {
                        if(difference >= (m-sum)) {
                            difference = m-sum;
                            result = sum;
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }
}
