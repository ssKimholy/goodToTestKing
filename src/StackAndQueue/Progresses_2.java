package StackAndQueue;

import java.util.*;

class Progresses_2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            que.offer((int) Math.ceil((100.0-progresses[i]) / speeds[i]));
        } // 남은 일수를 큐에 다 때려박는다.

        List<Integer> list = new ArrayList<>();

        while(!que.isEmpty()) {
            int tmp = 1;
            int day = que.poll();

            while (!que.isEmpty() && day >= que.peek()) {
                // 만약 앞 제품의 일수가 뒤 제품의 일수보다 작다면 앞제품 하나만 그 일수에 출하.
                // 앞 제품보다 뒤 제품 일수가 더 작다면 그 일수에 해당 제품개수만큼 출하.
                tmp++;
                que.poll();
            }

            list.add(tmp);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}