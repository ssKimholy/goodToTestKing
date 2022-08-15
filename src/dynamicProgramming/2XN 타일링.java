package dynamicProgramming;

public class Tailing2XN {
    int[][] dp;
    static final int NUM = 1_000_000_007;
    public int solution(int n) {
        int answer = 0;

        dp = new int[n+1][2];
        // 0은 가로로 끝나는 경우 1은 세로로 끝나는 경우

        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i-2][0] + dp[i-2][1]) % NUM;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % NUM;
        }

        answer = (dp[n][0] + dp[n][1]) % NUM;
        return answer;
    }
}
