package Greedy;

import java.util.*;

class ConnectIsland {
    static ArrayList<Bridge> graph = new ArrayList<>();
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 자기자신으로 부모를 초기화
        }

        for (int i = 0; i < costs.length; i++) {
            graph.add(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(graph);

        for (int i = 0; i < graph.size(); i++) {
            if (!find(graph.get(i).islandA, graph.get(i).islandB)) {
                // 두 섬이 union되어있지 않다면 최소의 비용을 추가하고 union.
                answer += graph.get(i).cost;
                union(graph.get(i).islandA, graph.get(i).islandB);
            }
        }

        return answer;
    }

    // 밑에서부터는 union-find algorithm.
    public int getParent(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = getParent(parent[i]);
    }

    public void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return true;
        }
        return false;
    }
}

class Bridge implements Comparable<Bridge> {
    int islandA;
    int islandB;
    int cost;

    public Bridge(int islandA, int islandB, int cost) {
        this.islandA = islandA;
        this.islandB = islandB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bridge bridge) {
        return this.cost - bridge.cost;
    } // 비용을 기준으로 정렬
}
