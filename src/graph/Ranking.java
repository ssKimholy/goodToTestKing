package graph;

import java.util.*;

public class Ranking {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[][] floyd;
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 기본적으로 k번째 노드가 순위가 정해지려면 k번째 노드 그 자신을 제외한 n-1개의 노드와의 비교에서
        // 승부를 가릴 수 있어야 한다. 승패에 상관없이 그래야 순위가 정해질 수 있기 때문이다.

        floyd = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] a : results) {
            floyd[a[0]-1][a[1]-1] = 1; // 이긴 경우
            floyd[a[1]-1][a[0]-1] = -1; // 진 경우
        }

        // 플로이드-워셜 algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        // k번째 노드를 통해 이긴 승부를 가릴 수 있다면 승부 체크
                        floyd[i][j] = 1;
                    }

                    if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                        // k번째 노드를 통해 진 승부를 가릴 수 있다면 승부 체크
                        floyd[i][j] = -1;
                    }
                }
            }
        }

        for (int[] a : floyd) {
            int count = 0;
            for (int check : a) {
                if (check != 0) {
                    count++;
                }
            }
            // n-1개의 노드에 대해서 0이 아니여야 한다.

            if (count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}