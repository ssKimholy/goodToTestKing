package BruteForce;

import java.util.*;

public class HanoiTower {
    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer;

        hanoi(n, 1, 3, 2);

        answer = new int[list.size()][2];

        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }


    // 하노이 알고리즘
    public void hanoi(int n, int start, int end, int via) {
        if (n == 1) {
            // 옮길 원판이 하나인 경우는 그냥 s, e로 옮기면 된다.
            list.add(new int[]{start, end});
            return;
        }

        hanoi(n-1, start, via, end); // n-1개의 원판을 s, v로 e를 경유지로 옮긴다.
        list.add(new int[]{start, end}); // 맨 밑의 원판을 s, e로 옮긴다.
        hanoi(n-1, via, end, start); // 마지막으로 n-1개의 원판을 v, e로 s를 경유지로 옮긴다.
    }
}
