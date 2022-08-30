package implementation;

import java.util.*;

public class FriendsBlock {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        HashSet<int[]> set = new HashSet<>();
        boolean isAdd;
        char[][] realBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            realBoard[i] = board[i].toCharArray();
        }

        while (true) {
            isAdd = false;
            set.clear();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m-1 || j == n-1) {
                        continue;
                    }
                    char c = realBoard[i][j];
                    if (c == '0') {
                        continue;
                    }

                    if (realBoard[i][j+1] == c && realBoard[i+1][j] == c && realBoard[i+1][j+1] == c) {
                        isAdd = true; // 2X2블럭 조건이 만족됐다면 set에 넣어 중복하지 않고 0으로 초기화
                        set.add(new int[]{i, j});
                        set.add(new int[]{i, j+1});
                        set.add(new int[]{i+1, j});
                        set.add(new int[]{i+1, j+1});
                    }
                }
            }

            if (!isAdd) break; // 만족하는 블럭이 없다면 더 이상 반복할 필요 X

            for (int[] a : set) {
                realBoard[a[0]][a[1]] = '0';
            }

            for (int j = 0; j < n; j++) {
                for (int i = m-1; i >= 0; i--) {
                    if (realBoard[i][j] == '0') {
                        for (int k = i-2; k >= 0; k--) {
                            if (realBoard[k][j] != '0') {
                                char tmp = realBoard[k][j];
                                realBoard[k][j] = realBoard[i][j];
                                realBoard[i][j] = tmp;
                                break; // 0과 해당 알파벳을 교체
                            }
                        }
                    }
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (realBoard[i][j] == '0') {
                    answer++;
                }
            }
        }

        return answer;
    }
}
