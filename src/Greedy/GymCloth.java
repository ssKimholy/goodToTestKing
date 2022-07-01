package Greedy;

import java.util.*;

class GymCloth {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];

        Arrays.fill(student, 1); // 우선 1로 다 채운 뒤

        for (int i : reserve) { // 더 가져온 학생과
            student[i]++;
        }

        for (int i : lost) { // 도둑질 맞은 학생 체육복 수를 계산한다.
            student[i]--;
        }

        for (int i = 1; i < student.length; i++) {
            // 그리디로 풀어야 하는 이유는 순서대로 체육복을 빌릴 때
            // 최대한 한 방향으로 빌려야지 최대한 많은 학생들이 균등하게 가지갈 수 있기 때문이다.


            if (student[i] == 0) {
                // 체육복이 없는 학생들 입장에서 본다.
                if (i == student.length-1) {
                    // 만약 마지막 학생이 체육복이 없다면 그 전 학생에게 빌릴 수 있도록 한다.
                    if (student[i-1] == 2) {
                        student[i-1]--;
                        student[i]++;
                    }
                    break;
                }
                // 전 사람과 앞 사람 둘 중 하나에게 빌려야 하는데 못 빌리는 경우가 생길 수도 있다.
                if (student[i-1] == 2 || student[i+1] == 2) {
                    if (student[i-1] == 2) {
                        // 먼저 최대한 전 사람에게 빌릴 수 있도록 한다.
                        student[i-1]--;
                        student[i]++;
                    } else {
                        // 만약 전 사람에게 빌리지 못하면 앞사람에게 빌리는데,
                        // 이 경우 때문에 뒤에 못 받는 사람이 생길 수 있다.
                        student[i+1]--;
                        student[i]++;
                    }
                }
            }
        }

        for (int i = 1; i < student.length; i++) {
            if (student[i] > 0) {
                // 체육복 있는 사람만 체크
                answer++;
            }
        }
        return answer;
    }
}
