package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 그룹 단어 체커 */
/* 시간복잡도 O(n*m^2) */
public class baekjoon_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<n; i++) {
            String word = br.readLine();
            boolean check = false;

            for(int j=0; j < word.length(); j++) {
                char preVal = word.charAt(j);

                for(int k=j+1; k < word.length(); k++) {
                    if(preVal == word.charAt(k)) {
                        if(word.charAt(k) == word.charAt(k-1)) {
                            continue;
                        } else {
                            check = true;
                        }
                    }
                }
            }
            if(!check) { count++; }
        }

        System.out.println( count );

    }
}
