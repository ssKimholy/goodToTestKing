package implementation;

import java.util.*;

public class FigureToLineUp {
    LinkedList<Integer> list = new LinkedList<>();
    int[] ans;
    int idx = 0;
    long facto = 1;

    public int[] solution(int n, long k) {
        ans = new int[n];

        for (int i = 1; i <= n; i++) {
            list.add(i);
            facto *= i;
        }

        cal(n-1, k-1, facto);
        return ans;
    }

    public void cal(int n, long k, long facto) {
        if (n == 0) {
            // 0!이 될때까지 n번 반복
            ans[idx++] = list.remove(0);
            return;
        }

        // k / (n-1)! = 현재 넣어야 하는 번호 인덱스
        // k % (n-1)! = 다음 k

        long fact = facto / (n+1); // 다음 단위 (n-1!)
        int val = Long.valueOf(k/fact).intValue();
        long remainder = k % fact;

        ans[idx++] = list.remove(val);
        cal(n-1, remainder, fact);
    }
}