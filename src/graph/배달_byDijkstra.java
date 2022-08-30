package graph;

import java.util.*;

public class Delivery_2 {
    static final int INF = 1_000_000_000;
    int[] d;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;
        d = new int[N+1];

        Arrays.fill(d, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(new Node(road[1], road[2]));
            graph.get(road[1]).add(new Node(road[0], road[2]));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (d[i] <= K) answer++;
        }

        return answer;
    }

    void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.getIdx();
            int distance = node.getDistance();

            if (d[idx] < distance) continue;

            for (int i = 0; i < graph.get(idx).size(); i++) {
                int cost = d[idx] + graph.get(idx).get(i).getDistance();
                if (cost < d[graph.get(idx).get(i).getIdx()]) {
                    d[graph.get(idx).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(idx).get(i).getIdx(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }

    int getIdx() {
        return this.idx;
    }

    int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        return this.getDistance() - other.getDistance();
    }
}
