package 백준.실버.IOIOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int totalCount = 0;
        String line = br.readLine();
        for(int i = 0; i < line.length() - 2; i++) {
            if(line.charAt(i) == 'I' && line.charAt(i + 1) == 'O' && line.charAt(i + 2) == 'I') {
                int count = 0;

                // 현재 위치에서 +2 까지의 요소가 'IOI' 되는 상황일 때
                while(i + 2 < line.length()
                        && line.charAt(i) == 'I'
                        && line.charAt(i + 1) == 'O'
                        && line.charAt(i + 2) == 'I'
                ) {
                    count++;

                    // 'IOI' 갯수가 n과 같거나 크면 출력 값인 totalCount 값 증가
                    if(count >= n) {
                        totalCount++;
                    }

                    // 다음 'I' 값으로 이동
                    i += 2;
                }
            }
        }

        System.out.println(totalCount);
    }
}
