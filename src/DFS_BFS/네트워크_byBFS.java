package DFS_BFS;

import java.util.*;

class NetWork_bfs {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문처리 되지 않은 컴퓨터를 기준으로 bfs.
                answer += bfs(computers, i);
            }
        }
        return answer;
    }

    public int bfs(int[][] computers, int current) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(current);
        visited[current] = true;

        while (!que.isEmpty()) {
            int computer = que.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[computer][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
        return 1;
        // bfs 한번에 한 네트워크를 탐색.
    }
}
