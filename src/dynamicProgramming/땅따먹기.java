package dynamicProgramming;

public class GroundGame {
    int[][] dp;

    int solution(int[][] land) {
        int answer = 0;

        dp = new int[land.length][4];

        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                switch(j) {
                    case 0:
                        dp[i][j] = Math.max(dp[i-1][j+1], Math.max(dp[i-1][j+2], dp[i-1][j+3])) + land[i][j];
                        break;
                    case 1:
                        dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j+1], dp[i-1][j+2])) + land[i][j];
                        break;
                    case 2:
                        dp[i][j] = Math.max(dp[i-1][j-2], Math.max(dp[i-1][j-1], dp[i-1][j+1])) + land[i][j];
                        break;
                    case 3:
                        dp[i][j] = Math.max(dp[i-1][j-3], Math.max(dp[i-1][j-2], dp[i-1][j-1])) + land[i][j];
                        break;
                }
            }
        }

        answer = Math.max(dp[land.length-1][0], Math.max(dp[land.length-1][1], Math.max(dp[land.length-1][2], dp[land.length-1][3])));

        return answer;
    }
}
