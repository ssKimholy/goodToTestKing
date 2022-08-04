package BruteForce;

import java.util.*;

public class NtoK {
    // 1,000,000을 3진수로 만들면 최대 14자리이기 때문에 메모리제한이 난다. 따라서 에라토스테네스의 체로 풀기에는 버겁다.
    // 따라서 소수판별 2번째 방법 root(n)까지 탐색하는 방법을 사용한다.
    public int solution(int n, int k) {
        int answer = 0;

        String[] results = kjin(n, k).split("0");
        // 조건은 0을 기준으로 나누었을때 무조건 만족한다.

        for (String result : results) {
            if (!result.equals("")) {
                // 00인 경우 split하면 공백이 나올 수 있다.
                long num = Long.parseLong(result);
                if (isPrime(num)) {
                    answer++;
                    // 소수라면 증가
                }
            }
        }

        return answer;
    }

    String kjin(int n, int k) {
        String jin = "";
        Stack<String> stack = new Stack<>();
        while (n >= k) {
            // k진수로 변환
            String div = String.valueOf(n % k);
            n /= k;
            stack.push(div);
        }
        stack.push(String.valueOf(n));

        while (!stack.isEmpty()) {
            jin += stack.pop();
        }
        return jin;
    }

    boolean isPrime(long num) {
        // 최대 14자리인 점을 유의해서 타입을 long으로 설정
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
