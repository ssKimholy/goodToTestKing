package implementation;

public class NumberBlockg {
    public int[] solution(long begin, long end) {
        Long be = Long.valueOf(begin);
        Long en = Long.valueOf(end);
        int Begin = be.intValue();
        int End = en.intValue();
        int[] answer = new int[End-Begin+1];

        for (int i = Begin; i <= End; i++) {
            if (i == 1) {
                answer[i-Begin] = 0;
                continue;
            } else answer[i-Begin] = 1; // 기본 값으로 1 설정.

            for (int j = 2; j <= Math.sqrt(i); j++) {
                // ex) 10 -> 1, 2, 5, 10 약수의 양쪽 끝 2개를 곱하면 몫이 나온다.
                // ex) 12 -> 1, 2, 3, 4, 6, 12
                // 따라서 약수의 중간까지만 구하면 약수 중 제일 큰 값을 골라낼 수 있다.
                // 약수 중 처음 값을 알면 그 값으로 몫을 나누면 약수 중 가장 큰 값을 알 수 있다.
                if (i % j == 0 && i / j <= 10000000) {
                    // 약수 중 10000000 이하인 블록만 골라낸다.
                    answer[i-Begin] = i / j;
                    break;
                }
            }
        }
        return answer;
    }
}
