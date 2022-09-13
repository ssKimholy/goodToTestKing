package dynamicProgramming;

public class JumpAsYouCan {
    static final int INF = 1_234_567;
    long[] dp = new long[2001];

    public long solution(int n) {
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // 1로 끝나는 경우와 2로 끝나는 경우로 나누어 생각해보자.
            dp[i] = (dp[i-2] + dp[i-1]) % INF;
        }

        return dp[n];
    }
}