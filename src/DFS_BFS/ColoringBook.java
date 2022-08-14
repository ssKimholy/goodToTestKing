package DFS_BFS;

import java.util.*;

public class ColoringBook {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];

        visited = new boolean[m][n];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i, j, picture, picture[i][j]);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    void bfs(int x, int y, int[][] picture, int color) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!que.isEmpty()) {
            int[] current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length) {
                    continue;
                }

                if (visited[nx][ny] || picture[nx][ny] == 0) continue;

                if (picture[nx][ny] == color) {
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }

        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
    }
}