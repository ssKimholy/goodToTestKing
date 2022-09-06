package dynamicProgramming;

public class FindLargestSqare
{
    int h, w;
    public int solution(int[][] board)
    {
        int answer = 1;
        h = board.length;
        w = board[0].length;

        if (checkToZero(board)) return 0;

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (board[i][j] == 0) continue;

                // ex) 3x3은 2x2 정사각형 3개가 필요하다. 이 요건이 충족이 안된다면 3x3이 될 수 없다.
                board[i][j] = Math.min(Math.min(board[i-1][j-1], board[i-1][j]), board[i][j-1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer*answer;
    }

    public boolean checkToZero(int[][] board) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 1) return false;
            }
        }

        return true;
    }
}
