package 백준.실버.신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Emp {
    int A;
    int B;
    public Emp(int a, int b) {
        A = a;
        B = b;
    }
}

public class Main {
    /* 신입 사원 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            Emp[] emps = new Emp[N];

            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                int A = Integer.parseInt(str[0]);
                int B = Integer.parseInt(str[1]);
                emps[j] = new Emp(A, B);
            }
            getMaxEmp(emps);
        }
    }

    public static void getMaxEmp(Emp[] emps) {
        int result = 1;
        Arrays.sort(emps, Comparator.comparingInt(o -> o.A));
        int currentVal = emps[0].B;
        for(int i=1; i < emps.length; i++) {
            if(emps[i].B < currentVal) {
                currentVal = emps[i].B;
                result++;
            }
        }
        System.out.println(result);
    }
}
