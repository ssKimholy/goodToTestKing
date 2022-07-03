package Greedy;

import java.util.*;

class makeMaxValue_2 {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int len = number.length() - k; // 리턴값의 길이
        int idx = 0;

        for (int i = 0; i < len; i++) {
            // 최대값을 찾는 반복문을 리턴값의 길이만큼 반복하면 됨.
            int max = Integer.MIN_VALUE;
            int op = k + 1 + i;
            // 규칙찾기 (리턴값 길이를 고려해서 범위를 넘어가지 못하게 한다.)
            for (int j = idx; j < op; j++) {
                if (number.charAt(j) == '9') {
                    // 9는 가장 큰 값이니 무조건 리턴값에 들어간다.
                    max = 9;
                    idx = j+1;
                    break;
                }
                if (max < number.charAt(j) - '0') {
                    // 최대값 갱신
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }

            sb.append(max);
        }

        return sb.toString();
    }
}
