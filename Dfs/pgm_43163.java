package Dfs;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 단어 변환
 */
public class pgm_43163 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };

        System.out.println(solution(begin, target, words));
    }

    private static int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word currentWord = queue.poll();

            if(currentWord.word.equals(target)) {
                return currentWord.depth;
            }

            for(int i=0; i<words.length; i++) {
                if(!visited[i] && isDiffChar(currentWord.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], currentWord.depth + 1));
                }
            }

        }

        return 0;
    }

    private static boolean isDiffChar(String fst, String sec) {
        int diffCount = 0;
        for(int i=0; i<fst.length(); i++) {
            if(fst.charAt(i) != sec.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }

    private static class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

}
