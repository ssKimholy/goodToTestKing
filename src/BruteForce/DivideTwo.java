package BruteForce;

import java.util.*;

class DivideTwo {
    static int answer = 1000;
    static boolean[] visited;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] a : wires) {
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }

        for (int[] a : wires) {
            Arrays.fill(visited, false);
            int left = bfs(a[0], a[1]);
            int right = bfs(a[1], a[0]);

            // 전력쌍 하나하나 끊어서 bfs돌고 차이의 최솟값을 리턴
            answer = Math.min(answer, (int) Math.abs(left - right));
        }

        return answer;
    }

    public int bfs(int p, int q) {
        int num = 1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(p);
        visited[p] = true;

        while (!que.isEmpty()) {
            int k = que.poll();

            for (int node : graph.get(k)) {
                if (node != q && !visited[node]) {
                    que.offer(node);
                    visited[node] = true;
                    num++;
                }
            }
        }

        return num;
    }
}