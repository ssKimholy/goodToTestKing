package binarySearch;

import java.util.*;

public class Stepping_Stone {
    // k개의 바위를 제거한 뒤 거리의 최솟값을 나열하고 그 중에서 가장 큰 값을 고르기 보다
    // 생각을 바꿔서 이분 탐색의 mid값을 거리의 최솟값 중 최대값이라고 가정하고 k개를 제거한다. (생긱을 뒤집어 본다.)

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return search(rocks, distance, n);
    }

    public int search(int[] rocks, int distance, int n) {
        long answer = 0; // 최대값을 담는 배열
        long left = 0;
        long right = distance;
        long mid = 0;
        // 이분 탐색에서 가장 중요한 두 가지: 첫째, 기준을 잡아라(해당 문제의 경우 바위 사이 거리의 최솟값 중 최대값) 둘째, 초기 right값을 설정하자. (나올 수 있는 가장 큰 값을 right에 초기로 설정)

        while (left <= right) {
            mid = (left + right) / 2;
            int pre = 0; // 현재 바위와 바로 전 바위의 차이를 구하기 위해 바로 전 바위의 위치를 저장하는 변수
            int count = 0;

            for (int rock : rocks) {
                if (rock - pre < mid) {
                    // 전 바위에서 현재 바위까지의 거리가 mid보다 작으면 mid가 최솟값이라는 가정이 깨지기 때문에 현재 바위를 제거한다.
                    count++;
                } else {
                    // 전 바위에서 현재 바위까지의 거리가 mid보다 크면 ok.
                    pre = rock;
                }
            }

            if (distance - pre < mid) {
                // 전 바위에서 도착지까지의 거리도 체크해야 한다.
                count++;
            }

            if (count <= n) {
                // 만약 제거한 바위의 개수가 n이하라면 left값을 수정하여 최대값을 늘린다.
                // left right가 교차할 때까지 최솟값들 중 최대값을 최대화 한다.
                answer = Math.max(answer, mid);
                left = mid+1;
            } else {
                // n보다 크다면, right를 조정해 mid값을 줄인다.
                right = mid-1;
            }
        }

        return (int) answer;
    }
}
