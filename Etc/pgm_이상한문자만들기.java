package Etc;

public class pgm_이상한문자만들기 {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int idx = 0;
        for(String val : arr) {
            if(idx % 2 == 0) {
                answer += val.toUpperCase();
            } else {
                answer += val.toLowerCase();
            }

            idx = val.equals(" ") ? 0 : idx + 1;
        }
        return answer;
    }
}
