package DFS_BFS;

import java.util.*;

class TripRoad {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    String[] solution(String[][] tickets) {
        String[] answer;
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 1);

        Collections.sort(list); // 사전순으로 앞서는 경로가 정답이니 사전순으로 정렬
        answer = list.get(0).split(" ");
        return answer;
    }

    void dfs(String start, String destination, String[][] tickets, int dep) {
        // 순서대로 목적지, 현재까지 경로, 티켓, 현재까지의 경로의 길이.
        if (dep == tickets.length + 1) {
            // 특정 길이 도달에 성공하면 하나의 경로이므로 리스트에 추가.
            // 특정 길이까지 도달 못하는 경우 dfs가 그냥 리턴되므로 모든 경우의 수 중 경로에 해당되는 것만 추릴 수 있다.
            list.add(destination);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                // 다음 목적지를 잡고 dfs
                visited[i] = true;
                dfs(tickets[i][1], destination + " " + tickets[i][1], tickets, dep+1);
                visited[i] = false; // 모든 경우의 수를 볼 것이기 때문에 다시 false로 복구.
            }
        }

    }

}
