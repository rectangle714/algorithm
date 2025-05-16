package Etc;

public class pgm_시저암호 {
    public static void main(String[] args) {
        // 소문자 65 ~ 90
        // 대문자 97 ~ 122
        System.out.println(solution("AaZz", 52));
    }

    public static String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
                continue;
            }

            char c = s.charAt(i);

            if('A' <= c && c <= 'Z') {
                answer += (char)(c % 'Z' + n) ;
            } else if('a' <= c && c <= 'z') {
                answer += (char)(c % 'z' + n) ;
            }
        }

        return answer;
    }
}
