package graph;

import java.util.*;

public class Deilvery {
    static final int INF = 1_000_000_000;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;


        int[][] fluid = new int[N+1][N+1];
        int n = fluid.length;

        for (int i = 1; i < n; i++) {
            Arrays.fill(fluid[i], INF);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) fluid[i][j] = 0;
            }
        }

        for (int i = 0; i < road.length; i++) {
            fluid[road[i][0]][road[i][1]] = Math.min(fluid[road[i][0]][road[i][1]], road[i][2]);
            fluid[road[i][1]][road[i][0]] = Math.min(fluid[road[i][1]][road[i][0]], road[i][2]);
            // 양방향 연결
        }


        // 플루이드-워셜 Algorithm.
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    fluid[i][j] = Math.min(fluid[i][j], fluid[i][k] + fluid[k][j]);
                }
            }
        }

        for (int i = 1; i < fluid.length; i++) {
            if (fluid[1][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
