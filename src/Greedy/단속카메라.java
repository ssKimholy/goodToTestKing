package Greedy;

import java.util.*;

class Camera {
    public int solution(int[][] routes) {
        int answer = 0;
        int idx = 0;

        Arrays.sort(routes, new Comparator<int[]>(){

            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    return (a2[1]-a2[0]) - (a1[1]-a1[0]);
                }
                return a1[0] - a2[0];
            }
            // 우선 고속도로를 일방향으로 통행한다고 가정하고, 첫 시작점을 기준으로 정렬한다.
        });

        while (idx < routes.length) {
            int k = routes[idx][1]; // 현재 차량의 종착점
            idx++;

            while (idx < routes.length) {
                // 현재 차량 출발-도착 range에 포함된 차량이 현재 차량 종착점을 넘어서 도착한다면, 카메라를 현재 차량의 종착점에 카메라를 설치해도 되지만
                // 만약 range에 포함된 차량이 range끝점보다 일찍 도착하고 현재차량의 종착점에 카메라를 설치한다면 그 차량을 단속하지 못한다.
                if (routes[idx][0] > k) {
                    break;
                }

                if (routes[idx][1] < k) {
                    // 때문에 현재 종착점보다 range안에 있는 차량의 종착점이 더 작다면 끝점을 갱신하고 카메라를 그 점으로 옮기면 한 번에 그 차량과 range에 포함된 차량들을 찍을 수 있다.
                    k = routes[idx][1];
                }
                idx++;
            }
            answer++;
        }
        return answer;
    }
}
