package Greedy;

import java.util.*;

class MakeMaxValue {
    public String solution(String number, int k) {
        String answer = "";

        int len = number.length() - k; // k개의 수를 제거하고 남은 수는 전체 문자열에서 k개 뺀 수만큼 숫자를 뽑은 수이다.
        int[] str = new int[len]; // 리턴값을 담을 배열
        Arrays.fill(str, Integer.MIN_VALUE); // 최대값을 계속 갱신해야하니 초기값은 가장 작은 값이어야 한다.
        int strIdx = 0; // 리턴값의 인덱스
        int lp = 0; // 최대값의 다음 인덱스 (리턴값에 들어간 수 다음부터 탐색을 시작하니 그만큼 시간이 줄어든다.)

        while (strIdx < len) {
            // 리턴값에 들어간 수 다음부터 탐색시작.
            for (int i = lp; i < number.length(); i++) {
                int num = number.charAt(i) - '0';
                if (num == 9) { // 9는 제일 큰 값이니 무조건 리턴값에 들어간다.
                    str[strIdx] = num; // 리턴값에 추가 후
                    strIdx++;
                    lp = i+1; // lp초기화
                    break;
                }
                int op = number.length() - (i+1); // 현재 인덱스에서 number배열 끝까지 남은수
                int strOp = len - (strIdx+1); // 현재 리턴값 인덱스에서 리턴값 길이까지 남은 수
                if (str[strIdx] < num) { // 만약 현재값보다 큰 값이 나온다면 최대값 갱신
                    str[strIdx] = num;
                    lp = i+1; // lp 갱신
                }
                if (op == strOp) {
                    // op와 strOp가 같아지면 더 이상 탐색을 진행할 이유가 없다.
                    strIdx++;
                    break;
                }
            }

        }

        for (int i : str) {
            answer += String.valueOf(i);
        }

        return answer;
    }
}
