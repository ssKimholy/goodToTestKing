package StackAndQueue;

import java.util.*;

class Progresses {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        int idx = 0;
        int len = progresses.length;

        while(idx < len) {
            int tmp = 0;

            for (int i = 0; i < len; i++) {
                progresses[i] += speeds[i];
            }

            while(idx < len) {
                if (progresses[idx] >= 100) {
                    tmp++;
                } else {
                    break;
                }
                idx++;
            }

            if (tmp != 0) {
                que.offer(tmp);
            }
        }
        int[] answer = new int[que.size()];
        idx = 0;

        while(!que.isEmpty()) {
            answer[idx] = que.poll();
            idx++;
        }
        return answer;
    }
}