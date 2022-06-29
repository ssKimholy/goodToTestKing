package StackAndQueue;

import java.util.*;
// 두 가지 조건으로 분류되는 수형도 문제는 한 조건을 우선 분류한 뒤, 나머지 조건을 안에서 다시 분류.

class TruckThruBridge_2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int front = 0;

        Queue<Integer> que = new LinkedList<>();

        for (int truck : truck_weights) {

            while (true) { // 다리의 길이를 조건으로 놓고 분류

                if (que.isEmpty()) { // 다리에 트럭이 하나도 안 올라와 있는 경우.
                    // 이 경우 일단, 맨 앞 트럭을 다리에 올린다.
                    que.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (que.size() == bridge_length) { // 다리에 트럭이 꽉 찬 경우.
                    sum -= que.poll(); // 다리에 끝에 있는 트럭을 하나 뺀다. (시간은 카운트 X)
                } else { // 다리에 트럭이 꽉 차지 않은 경우.
                    // 이 경우 다리의 적하량 문제로 또 케이스가 분류된다.
                    if (sum + truck <= weight) { // 다음 트럭이 올라와도 다리가 버티는 경우.
                        que.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else { // 다음 트럭이 올라오면 다리가 못 버텨 공백을 삽입하는 경우.
                        que.offer(0);
                        answer++;
                    }
                }
            }
        }

        return answer + bridge_length; // 마지막으로 올라탄 트럭은 반복문에서 시간 체크를 하지 않았기 때문에
        // 올라탄 그 순간부터 내리는 시간인 다리의 길이를 더해준다.
    }
}
