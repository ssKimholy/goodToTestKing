package StackAndQueue;

import java.util.*;

class Printer_3 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que.offer(i);
        }

        while (!que.isEmpty()) {
            int tmp = que.poll();
            boolean isChange = false;

            for (int a : que) {
                if (priorities[tmp] < priorities[a]) {
                    isChange = true;
                    break;
                }
            }

            if (isChange) {
                que.offer(tmp); // 만약 작업대기순서가 바꾸었다면 작업대기중이던 작업을 맨 뒤로
            } else {
                if (tmp == location) {
                    // 그대로 출력한다면, 우리가 찾는 작업이면
                    // 순서를 리턴, 아니라면 순서상향
                    return answer;
                }
                answer++;
            }
        }
        return answer;
    }
}
