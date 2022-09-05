package BruteForce;

public class QuadPress {
    int zero; int one;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        zero = 0; one = 0;

        divide(0, arr.length, 0, arr.length, arr);

        answer[0] = zero; answer[1] = one;
        return answer;
    }

    // divide-and-conquer
    void divide(int startR, int endR, int startC, int endC, int[][] arr) {
        int ze = 0; int on = 0;
        for (int i = startR; i < endR; i++) {
            for (int j = startC; j < endC; j++) {
                if (arr[i][j] == 0) ze++;
                else on++;
            }
        }

        // 배열 내 숫자가 한 개이거나 크기가 1이거나
        if (ze == 0 || on == 0) {
            if (ze == 0) one++;
            else zero++;
            return;
        }

        divide(startR, (startR+endR)/2, startC, (startC+endC)/2, arr);
        divide((startR+endR)/2, endR, startC, (startC+endC)/2, arr);
        divide(startR, (startR+endR)/2, (startC+endC)/2, endC, arr);
        divide((startR+endR)/2, endR, (startC+endC)/2, endC, arr);
    }
}
