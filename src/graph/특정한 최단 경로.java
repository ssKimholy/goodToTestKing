import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph;
    static int[][] d;
    static final int INF = 200_000_000; // 1000*2000000 이상이면 최단 경로라고 볼 수 없다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        d = new int[N+1][N+1];

        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(d[i], INF);
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
            // 양방향 연결
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        // 임의의 두 경로

        dijkstra(1); // start지점만 1, A, B로 설정하고 3번만 다익스트라를 돌리면 된다. (굳이 모든 vertex에 대해 다익스트라 돌 필요없다.)
        dijkstra(A);
        dijkstra(B);

        answer = Math.min(d[1][A] + d[A][B] + d[B][N], d[1][B] + d[B][A] + d[A][N]); // 1 -> A -> B -> N OR 1 -> B -> A -> N
        // 둘 경로 중 하나가 최단 경로이다.
        if (answer >= INF) {
            // 최단경로가 없는 경우
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start][start] = 0;

        while (!pq.isEmpty()) {
            Node nodes = pq.poll();
            int distance = nodes.getDistance();
            int now = nodes.getIdx();

            if (d[start][now] < distance) continue; // 이미 처리가 된 노드는 더 이상 반복문을 탈 필요가 없다. (이미 최단 경로를 갱신한 노드이기 때문에)

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[start][now] + graph.get(now).get(i).getDistance();
                if (cost < d[start][graph.get(now).get(i).getIdx()]) {
                    d[start][graph.get(now).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIdx(), cost));
                    // 우선순위 큐에 삽입.
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

    public int getIdx() {
        return idx;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public int compareTo(Node n) {
        return this.getDistance() - n.getDistance();
    } // 거리 순으로 정렬
}
