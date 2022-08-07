package BruteForce;

public class UnDistroyBuilding {
    static int M, N;
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        M = board.length; N = board[0].length;
        int[][] temp = new int[M + 1][N + 1];
        // 누적합 공식을 사용하려면 범위가 벗어나는 경우가 있기 때문에 한칸씩 늘려서 범위를 벗어나지 않게 만든다.

        for (int[] skill : skills) {
            int x1 = skill[1], y1 = skill[2], x2 = skill[3], y2 = skill[4];
            int num = skill[0] == 1 ? -skill[5] : skill[5];

            temp[x1][y1] += num;
            temp[x2+1][y1] += -num;
            temp[x1][y2+1] += -num;
            temp[x2+1][y2+1] += num;
            // 누적합 공식
        }

        // 누적합 실행.
        for (int i = 0; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                temp[i][j] += temp[i][j-1];
            }
        }

        for (int j = 0; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                temp[i][j] += temp[i-1][j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] + temp[i][j] > 0) {
                    answer++;
                    // 파괴되지 않은 건물이 몇 개인지 카운트
                }
            }
        }

        return answer;
    }
}