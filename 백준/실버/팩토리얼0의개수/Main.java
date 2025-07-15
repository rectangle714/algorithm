package 백준.실버.팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒷자리가 0이 되기 위해서는 2와 5가 필요한데,
// 2의 갯수는 좀 더 많기 때문에 적은 갯수인
// 5를 나눠주면서 count 해주면 0의 갯수를 찾을 수 있다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);
    }
}
