package dynamicProgramming;

import java.util.*;

public class ToN {
    ArrayList<HashSet<Integer>> dp;
    // n으로 표현하려면 중복이 발생하기에 set을 쓴다.
    public int solution(int N, int number) {
        int answer = 0;

        dp = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);
        // n하나로 표현할 수 있는 수는 n자신뿐이다.

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                HashSet<Integer> pre = dp.get(j);
                HashSet<Integer> post = dp.get(i - j);
                // ex) 3 = 1 + 2 (pre + post) || 2 + 1 (pre + post)

                for (int p : pre) {
                    for (int q : post) {
                        dp.get(i).add(p+q);
                        dp.get(i).add(p-q);
                        dp.get(i).add(p*q);

                        if (q != 0) {
                            dp.get(i).add(p / q);
                        }
                    }
                }
            }

            String n = "";
            for (int j = 1; j <= i; j++) {
                n += String.valueOf(N);
            } // ex) 5 2개면 55 3개면 555
            dp.get(i).add(Integer.parseInt(n));
        }

        for (HashSet<Integer> idx : dp) {
            if (idx.contains(number)) {
                return dp.indexOf(idx);
            }
        }
        return -1;
    }
}
