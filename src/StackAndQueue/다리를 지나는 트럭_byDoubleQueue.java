package StackAndQueue;

import java.util.*;

class TruckThruBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int front = 0;

        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> weights = new LinkedList<>();

        for (int a : truck_weights) {
            weights.offer(a);
        }


        while (!weights.isEmpty()) {
            front = weights.peek();
            // 다리에 올라갈 트럭의 무게

            while (sum + front <= weight && que.size()+1 <= bridge_length) {
                // 만약 현재 다리에 있는 무게와 올라갈 트럭의 무게의 합이 weight를 넘지 않고
                // 다리 길이도 맞다면 트럭을 하나 올린다.
                front = weights.poll();
                que.offer(front);
                sum += front;
                answer++;

                if (!weights.isEmpty()) {
                    front = weights.peek();
                    // 올라갈 트럭들이 남았다면 다음 올라갈 트럭을 배치
                } else {
                    break;
                }
            }

            if (que.size() == bridge_length) {
                sum -= que.poll();
                // 다리가 꽉 찼다면 하나 내려준다. 여기서 시간을 체크하지 않는 이유는
                // 하나가 내려가고 빈자리에 또 하나가 동시 올라가기 때문에 중복체크를 피하기 위해서이다.
            } else {
                if (!weights.isEmpty()) {
                    que.offer(0); // 여유있는 자리에 공백을 위하여 0을 삽입한다.(최소 시간을 위한 키포인트)
                    answer++;
                }
            }
        }

        return answer + bridge_length; // 마지막 트럭은 반복문에서 시간 체크를 하지 못했기 때문에
        // 올라가 있는 상태에서 내려올때까지 시간인 다리의 길이를 더해주면서 끝난다.
    }
}
