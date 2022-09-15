package implementation;

public class NradixGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "";

        // 인원 수에 맞게 게임을 진행하려면 t*m개만큼의 길이가 보장되어야 한다.
        for (int i = 0; tmp.length() <= t*m; i++) {
            tmp += Integer.toString(i, n);
        }

        for (int i = 0; i < t*m; i++) {
            // 튜브가 말해야 하는 순서에만 골라서 담기.
            if ((i%m)+1 == p) {
                answer += tmp.charAt(i);
            }
        }

        return answer.toUpperCase();
    }
}