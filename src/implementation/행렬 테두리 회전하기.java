package implementation;

public class RotationSide {
    int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int min = 0;
        int idx = 0;

        makeMat();

        for (int[] query : queries) {
            int y1 = query[0]-1, x1 = query[1]-1, y2 = query[2]-1, x2 = query[3]-1;
            int pre = arr[y1][x1];
            min = pre;
            int tmp = 0;
            for (int i = x1+1; i <= x2; i++) {
                tmp = arr[y1][i];
                arr[y1][i] = pre;
                pre = tmp;
                min = Math.min(min, pre);
            }

            for (int i = y1+1; i <= y2; i++) {
                tmp = arr[i][x2];
                arr[i][x2] = pre;
                pre = tmp;
                min = Math.min(min, pre);
            }

            for (int i = x2-1; i >= x1; i--) {
                tmp = arr[y2][i];
                arr[y2][i] = pre;
                pre = tmp;
                min = Math.min(min, pre);
            }

            for (int i = y2-1; i >= y1; i--) {
                tmp = arr[i][x1];
                arr[i][x1] = pre;
                pre = tmp;
                min = Math.min(min, pre);
            }

            answer[idx] = min;
            idx++;
        }

        return answer;
    }

    void makeMat() {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = num++;
            }
        }
    }
}
