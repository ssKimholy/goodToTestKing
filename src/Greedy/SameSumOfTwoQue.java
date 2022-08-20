package Greedy;

import java.util.*;

public class SameSumOfTwoQue {
    long s1, s2;
    Queue<Integer> que1 = new LinkedList<>();
    Queue<Integer> que2 = new LinkedList<>();
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        s1 = 0; s2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            s2 += queue2[i];
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
        }

        if ((s1+s2) % 2 == 1) return -1; // 홀수는 반으로 나눌 수 없다.

        answer = cal();

        return answer;
    }

    int cal() {
        int num = 0;
        while (num <= que1.size() + que2.size() + 2) {
            // 두 큐의 사이즈 + 1 이 왕복을 했는데도 균형점을 못 찾았다면 균형점이 없는 것.
            int k;

            if (s1 > s2) {
                k = que1.poll();
                s1 -= k; s2 += k;
                que2.offer(k);
            } else if (s1 < s2) {
                k = que2.poll();
                s2 -= k; s1 += k;
                que1.offer(k);
            } else {
                return num;
            }
            num++;
        }
        return -1; // 균형점이 없다면 -1 리턴.
    }
}