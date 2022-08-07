package BruteForce;
import java.util.Arrays;

public class ShootingArrow {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] temp = new int[11];
        int maxGap = 0;

        for (int i = 1; i < (1<<10); i++) {
            // bitmasking을 이용해서 라이언이 이기는 모든 경우의 수를 본다. (몇 점에서 이겨서 이기는지)
            int apeach = 0, ryan = 0, count = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    // 만약 라이언이 이기는 점수판이면 쏜 화살의 개수와 점수를 더한다.
                    temp[j] = info[j] + 1;
                    count += temp[j];
                    ryan += 10 - j;
                } else {
                    if (info[j] != 0) {
                        // 둘 다 0점이면 아무도 점수를 얻지 못한다.
                        apeach += 10 - j;
                    }
                    temp[j] = 0;
                }
            }
            temp[10] = n - count; // 남은 화살은 0점에 쏜다.

            if (count > n) { // 라이언이 날린 총 화살이 주어진 개수보다 많으면 모순.
                continue;
            }

            int gap = ryan - apeach;

            if (maxGap == gap) {
                // 현재 경우가 최대 갭이라면 작은 점수에서 더 많이 맞춘 경우가 answer로 들어간다.
                for (int j = 10; j >= 0; j--) {
                    if (temp[j] > answer[j]) {
                        answer = Arrays.copyOf(temp, temp.length);
                        break;
                    } else if (temp[j] < answer[j]) {
                        break;
                    }
                }
            } else if (maxGap < gap) {
                // 최대 값이 갱신되면 answer에 현재 경우를 넣는다.
                maxGap = gap;
                answer = Arrays.copyOf(temp, temp.length);
            }
        }

        if (maxGap == 0) {
            // 라이언이 이길 수 없는 케이스라면 -1을 리턴한다.
            return new int[] {-1};
        }
        return answer;
    }
}
