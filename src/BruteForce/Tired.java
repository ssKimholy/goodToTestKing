package BruteForce;

class Tired {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);

        return answer;
    }

    void dfs(int dep, int[][] dungeons, int k) {
        // 현재 깊이가 어느정도이고 그 깊이의 최대치를 answer에 저장.
        answer = Math.max(answer, dep);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                // 순열 알고리즘
                visited[i] = true;
                if (k >= dungeons[i][0]) {
                    dfs(dep+1, dungeons, k - dungeons[i][1]);
                    // 현재 피로도가 최소 필요 피로도보다 크면 자동으로 소모 피로도보다 크니까 dfs를 돌린다.
                }
                visited[i] = false;
            }
        }
    }
}