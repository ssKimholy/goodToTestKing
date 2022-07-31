package graph;

public class Taxi {
    int[][] ans;
    static final int INF = 100_000_000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        ans = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = INF;
                }
            }
        }

        for (int[] fare : fares) {
            ans[fare[0]][fare[1]] = fare[2];
            ans[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, ans[s][i] + ans[i][a] + ans[i][b]);
        }

        return answer;
    }
}
