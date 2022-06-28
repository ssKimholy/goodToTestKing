package StackAndQueue;

import java.util.*;

class Printer {
    public int solution(int[] priorities, int location) {
        int[] arr = new int[priorities.length];
        int count = 1;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que1.offer(i); // 우선순위 인덱스를 다 담아준다.
        }

        while (count <= arr.length) {
            int tmp = que1.poll();

            while(!que1.isEmpty()) {
                if (priorities[tmp] < priorities[que1.peek()]) {
                    // 작업대기 중인 값보다 더 큰 작업이 있다면 작업대기 작업 변경
                    que1.offer(tmp);
                    tmp = que1.poll();
                    while(!que2.isEmpty()) {
                        que1.offer(que2.poll());
                    }
                } else {
                    que2.offer(que1.poll());
                }
            }

            arr[tmp] = count++; // 출력해야할 작업의 count를 배열에 삽입한다.

            while(!que2.isEmpty()) {
                que1.offer(que2.poll());
            }
        }


        return arr[location];
    }
}