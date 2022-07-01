package Greedy;

import java.util.*;

class GymCloth_2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        // 체육복이 없는 애들은 제외하고 시작.

        Arrays.sort(lost); // 정렬되어 주어진다는 보장이 없다.
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    // 만약 여벌 옷을 가져온 학생이 도둑 맞았다면
                    // 그 학생은 체육에 참여할 수 있지만, 옷을 빌려줄 순 없다.
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; // 그 학생을 제외한다는 의미로 -1을 넣는다.
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    // 체육복이 없는 학생 앞 뒤에 여벌 옷이 있는 학생이 있다면
                    // 그 학생은 옷을 빌려 체육에 참여할 수 있다.
                    answer++;
                    reserve[j] = -1; // 빌려준 학생은 더 이상 체육복을 빌려줄 수 없다.
                    break;
                }
            }
        }
        return answer;
    }
}