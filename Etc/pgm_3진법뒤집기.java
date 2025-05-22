package Etc;

public class pgm_3진법뒤집기 {
    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.reverse();

        for(int i=sb.length() - 1; i>=0; i--) {
            int val = 0;
            val = (int) (Integer.parseInt(sb.charAt(i)+"") * Math.pow(3, i));
            answer += val;
        }

        return answer;
    }
}
