package 백준.브론즈.ISBN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int result = 0;
        int check = 0;
        
        
        for(int i = 0; i < isbn.length(); i++) {
            // 1. 훼손된 숫자 index 값을 구해준다
            if(isbn.charAt(i) == '*') {
                check = i;
                continue;
            }
            
            // 2. 각각 자리별 곱하기 1 혹은 곱하기 3 한 값을 result에 더해준다
            int val = isbn.charAt(i) - '0';
            if(i % 2 == 0) {
                result += val;
            } else {
                result += val * 3;
            }
        }

        int val = 0;
        while(true) {
            // 3. 훼손된 숫자 index 값이 홀수인지 짝수인지 확인
            // 4. 홀수면 result 값에 val * 3,
            //    짝수면 val 값을 더해주고 10으로 나눴을 때 0인지 체크 후 출력
            if(check % 2  == 0) {
                if((result + val) % 10 == 0) {
                    System.out.println(val);
                    break;
                }
            } else {
                if((result + val * 3) % 10 == 0) {
                    System.out.println(val);
                    break;
                }
            }

            val++;
        }
    }
}
