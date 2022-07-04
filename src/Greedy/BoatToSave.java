package Greedy;

import java.util.*;

class BoatToSave {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> deq = new ArrayDeque<>(); //que의 양쪽값을 컨트롤해야할때는 덱을쓴다.
        int answer = 0;

        for (int a : people) {
            deq.offer(a);
        } // 오름차순 정렬 후 덱에 넣는다.

        while (!deq.isEmpty()) {
            int person = deq.pollFirst();
            int num = 0;

            while (!deq.isEmpty()) {
                num = deq.pollLast();
                // 오른차순 상태이기에 맨앞 + 맨뒤가 limit을 안넘는다면 그 두명을 보트에 먼저 태우는 것이 보트를 최소한으로 쓸 수 있는 최적의 해가 된다.
                if (person + num <= limit) {
                    break;
                }
                answer++;
                // 만약 맨앞 + 맨뒤가 limit을 넘는다면 맨뒤의 사람은 제일 작은 값이랑 더해도 limit을 넘어가는 것이니, 혼자타야 한다.
            }

            answer++;
        }

        return answer;
    }
}
