package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문서 검색
 */
public class baekjoon_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String word = br.readLine();

        int result = 0;
        for(int i=0; i<sentence.length(); i++) {
            if(sentence.startsWith(word, i)) {
                i += word.length() -1;
                result++;
            }
        }

        System.out.println(result);
    }
}
