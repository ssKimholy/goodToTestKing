package implementation;


public class Imple124 {

    public String solution(int n) {
        String answer = "";


        while (n > 0)  {
            int tmp = n % 3; // 1, 2, 4 중 하나가 각 자리수에 들어갈 수 있기 때문에 3진수처럼 처리한다.
            n /= 3;
            if (tmp == 0) {
                // 만약 1, 2, 4 중에서 4가 자리수에 나오면 나머지가 0이라는 뜻이고, 나머지 자리수에도 영향을 미치기 때문에 몫에서 1을 빼준다.
                n -= 1;
                tmp = 4;
            }
            answer = String.valueOf(tmp) + answer;
        }

        return answer;
    }
}
