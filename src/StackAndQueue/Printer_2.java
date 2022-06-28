package StackAndQueue;

import java.util.*;

class Printer_2 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 우선수위 큐에 담는다.

        for (int a : priorities) {
            pq.add(a);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 프린트한 다음 그 뒤에 작업까지도 우선순위를 확인해야하기에
                // for문을 완전히 벗어나지는 않는다.
                if (priorities[i] == pq.peek()) {
                    // 만약 가장 순위가 높은 것이 현재 찾고 있는 작업이라면
                    // 순서를 리턴 (가장 우선순위가 높은 것이 프린트해야할 작업)
                    if (location == i) {
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }

        return 0;
    }
}
