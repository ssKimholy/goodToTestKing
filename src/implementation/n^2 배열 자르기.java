package implementation;

import java.util.*;

public class N_2_cut {
    public int[] solution(int n, long left, long right) {
        ArrayList<Long> list = new ArrayList<>();
        long start = left / n; // 시작하는 몫
        long end = right / n; // 끝나는 몫
        long startR = left % n; // 시작하는 인덱스
        long endR = right % n; // 끝나는 인덱스

        while (start != end) {
            for (long i = startR; i < n; i++) {
                list.add(Math.max(start, i) + 1);
            } // 시작 인덱스부터 n-1인덱스까지 규칙에 따라 넣고
            start++;
            startR = 0;
        }
        for (long i = startR; i <= endR; i++) {
            list.add(Math.max(start, i) + 1);
        } // 마지막 몫에서 처리

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Long.valueOf(list.get(i)).intValue();
        } // 정수형 배열로 바꾸고 리턴

        return answer;
    }
}
