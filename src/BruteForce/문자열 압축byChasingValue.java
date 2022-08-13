package BruteForce;

import java.util.ArrayList;

public class CompressStr_2 {
    StringBuilder sb;
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            // 절반길이 이상 자르면 압축하는 의미가 없어진다. (압축이 되지도 않는다.)
            sb = new StringBuilder();
            String st = s.substring(0, i); // 추적값 설정
            int cnt = 1;

            for (int j = i; j < s.length(); j += i) {
                String str = s.substring(j, j+i > s.length() ? s.length() : j+i);

                if (str.equals(st)) {
                    // 현재 문자열이 추적값과 일치하면 카운트
                    cnt++;
                } else {
                    // 다른 문자열이 나오면 현재까지의 카운트와 추적값을 넣고 현재 값으로 추적값 변경
                    sb.append(cnt == 1 ? "" : cnt).append(st);
                    st = str;
                    cnt = 1;
                }
            }
            // 마지막 문자열까지 처리
            sb.append(cnt == 1 ? "" : cnt).append(st);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

}
