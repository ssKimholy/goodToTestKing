package DFS_BFS;

import java.util.*;

public class FartestNode {
    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] vertex) {
        int answer = 0;

        arr = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : vertex) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            // 양방향 연결.
        }

        bfs(1);

        Arrays.sort(arr);

        for (int a : arr) {
            if (a == arr[arr.length-1]) {
                answer++;
            }
        }

        return answer;
    }

    void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int next = que.poll();

            for (int node : graph.get(next)) {
                if (!visited[node]) {
                    visited[node] = true;
                    arr[node] = arr[next]+1;
                    // 그 전 노드까지의 최단거리에서 1을 더해준 값을 저장.
                    que.offer(node);
                }
            }
        }
    }
}