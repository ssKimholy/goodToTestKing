package implementation;

public class TriangleSnail {
    public int[] solution(int n) {
        int[] answer;
        int[][] arr = new int[n][n]; // 달팽이 배열
        int num = n;
        int x = n, y = -1;
        int cnt = 1;
        while (num > 0) {
            for (int i = 0; i < num; i++) {
                x--; y++;
                arr[y][x] = cnt++;
            }
            num--; // 대각선 채우기

            for (int i = 0; i < num; i++) {
                x++;
                arr[y][x] = cnt++;
            }
            num--; // 오른쪽 이동

            for (int i = 0; i < num; i++) {
                y--;
                arr[y][x] = cnt++;
            }
            num--; // 위쪽 이동
            // 이 후 반복
        }

        answer = new int[cnt-1];
        int idx = 0;
        int start = n-1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = start; j < arr[0].length; j++) {
                answer[idx++] = arr[i][j];
            }
            start--;
        }

        return answer;
    }
}
