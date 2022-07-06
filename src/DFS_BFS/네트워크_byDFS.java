package DFS_BFS;

class NetWork_dfs {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        visited[0] = true; // 0번째 컴퓨터부터 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i] || i == 0) {
                // dfs를 돌았는데도 방문처리가 되지 않은 컴퓨터는 독립적인 별개의 네트워크를 가지고 있는 것.
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int num) {
        for (int i = 0; i < computers.length; i++) {
            if (i == num) { // 자기 자신과의 연결
                continue;
            }
            if (computers[num][i] == 1 && !visited[i]) {
                // 연결되어 있고 방문되지 않은 것을 방문처리 후 dfs.
                visited[i] = true;
                dfs(computers, i);
            }
        }
        // 한 번 dfs 사이클을 돌면, 한 네트워크에 있는 모든 컴퓨터들이 방문처리가 된다.
        // 중요한 것은 input이 꼭 대칭행렬이라는 보장이 없다는 것이다.(1번 배열에서 3번을 1로 처리해도 3번 배배열에서 1번을 0으로 해도 된다는 뜻).
        return;
    }
}
