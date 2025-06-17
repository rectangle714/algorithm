package 프로그래머스.시저암호;

public class pgm_시저암호 {
    public static void main(String[] args) {
        // 소문자 65 ~ 90
        // 대문자 97 ~ 122
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                answer += " ";
                continue;
            }

            if('A' <= c && c <='Z') {
                char value = (char)((c - 'A' + n) % 26 + 'A');
                answer += value;
            } else if('a' <= c && c <='z') {
                char value = (char)((c - 'a' + n) % 26 + 'a');
                answer += value;
            }
        }

        return answer;
    }
}
