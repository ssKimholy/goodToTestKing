package Greedy;

import java.util.*;

class JoiStick {
    public int solution(String name) {
        int answer = 0;
        char[] ch = name.toCharArray();
        int[] arr = new int[ch.length];
        for (int i = 0; i < arr.length; i++) {
            // 우선 N을 기준으로 A에서부터 더 짧은 거리를 계산해 배열에 넣는다.
            if (ch[i] <= 'N') {
                arr[i] = ch[i] - 'N' + 13;
            } else {
                arr[i] = 'N' - ch[i] + 13;
            }
        }

        int len = arr.length;
        int idx = 0; // 다음 인덱스 확 인
        int moveCount = len-1; // 움직임의 최소 값

        // 배열값과 움직임은 독립적이다. 이 문제에서는 움직임의 최소 값을 구해야 답을 맞출 수 있다.
        // 배열값은 어짜피 추가되어야 하는 값이지만 움직임은 최소 값을 구할 수 있다.
        for (int i = 0; i < len; i++) {
            answer += arr[i]; // 배열값 추가

            idx = i+1;
            // 다음 인덱스부터 연속된 A의 값들이 끝나는 지점을 구해서
            while (idx < len && arr[idx] == 0) {
                idx++;
            }

            // 현재까지의 움직임의 최소값과 현재 인덱스까지 온 뒤 연속된 A값이 끝나는 지점까지 되돌아가는 것중에 무엇이 더 작은지 체크
            moveCount = Math.min(moveCount, i*2 + len-idx);

            // 처음부터 뒤로 돌아가 현재인덱스까지 오는게 더 거리가 줄 수도 있다.
            moveCount = Math.min(moveCount, (len-idx)*2 + i);
        }

        return answer + moveCount;
    }
}
