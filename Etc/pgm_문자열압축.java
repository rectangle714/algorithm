package Etc;

public class pgm_문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    public static int solution(String s) {
        int minLength = s.length(); // 최소 길이를 문자열 전체 길이로 초기화

        // 1부터 문자열 길이의 절반까지 잘라보면서 압축
        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len); // 첫 블록
            int count = 1;

            // len 단위로 문자열을 순회
            for (int j = len; j <= s.length(); j += len) {
                // 다음 블록
                String next;
                if (j + len <= s.length()) {
                    next = s.substring(j, j + len);
                } else {
                    // 남은 부분 추가 (더 이상 잘릴 블록이 없는 경우)
                    compressed.append(count > 1 ? count : "").append(prev);
                    compressed.append(s.substring(j));
                    prev = "";
                    break;
                }

                // 이전 블록과 같은 경우
                if (prev.equals(next)) {
                    count++;
                } else {
                    // 압축된 결과 추가
                    compressed.append(count > 1 ? count : "").append(prev);
                    prev = next;
                    count = 1;
                }
            }

            // 마지막 블록 처리
            if (!prev.equals("")) {
                compressed.append(count > 1 ? count : "").append(prev);
            }

            // 최소 길이 갱신
            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
