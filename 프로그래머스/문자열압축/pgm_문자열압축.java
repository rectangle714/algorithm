package 프로그래머스.문자열압축;

public class pgm_문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    public static int solution(String s) {
        int minLength = s.length();

        for(int i=1; i <= s.length() / 2; i++) {
            int count = 1;
            String preStr = s.substring(0, i);
            String compressed = "";

            for(int j=i; j <= s.length(); j += i) {
                String nextStr = "";

                if(j + i <= s.length()) {
                    nextStr = s.substring(j, j + i);
                } else {
                    if(count > 1) {
                        compressed += count;
                    }
                    compressed += preStr;
                    compressed += s.substring(j);
                    preStr = "";
                    break;
                }

                if(preStr.equals(nextStr)) {
                    count++;
                } else {
                    if(count > 1) {
                        compressed += count;
                    }
                    compressed += preStr;
                    preStr = nextStr;
                    count = 1;
                }
            }

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
