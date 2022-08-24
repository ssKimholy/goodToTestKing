package implementation;

import java.util.*;

public class CycleLight {
    ArrayList<Integer> list = new ArrayList<>();
    boolean[][][] visited; // 한 정점에서 동서남북으로 빛을 쏜 경우가 있는지 확인한다.
    int[] dy = {1, 0, -1, 0}; // 남, 동, 북, 서 방향
    int[] dx = {0, 1, 0, -1};
    int M, N;
    // 사이클이라 어디서부터 스타트를 하는지는 상관없고 시작한 곳으로 돌아오기만 하면 된다.
    public int[] solution(String[] grid) {
        M = grid.length;
        N = grid[0].length();
        visited = new boolean[M][N][4];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        list.add(bfs(grid, i, j, k));
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    int bfs(String[] grid, int y, int x, int d) {
        int count = 0;
        // 전 정점에서 현 정점으로 오는 방향도 캐치할 수 있는 방법이다.

        while (true) {
            if (visited[y][x][d]) break;

            visited[y][x][d] = true;

            if (grid[y].charAt(x) == 'L') {
                // 틀어야 할 경우에는 규칙에 맞게 방향조절
                d = d == 3 ? 0 : d+1;
            } else if (grid[y].charAt(x) == 'R') {
                d = d == 0 ? 3 : d-1;
            }

            y = y + dy[d];
            x = x + dx[d];

            if (y == M || y < 0) {
                if (y == M) y = 0;
                else y = M-1;
            } else if (x == N || x < 0) {
                if (x == N) x = 0;
                else x = N-1;
            }

            count++;
        }

        return count;
    }
}