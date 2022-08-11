package BruteForce;

public class AdInsert {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[] users = new int[360_000]; // 초로 전환시 최대 359_999초까지 나온다.
        int adTime = convertToInt(adv_time);
        int playTime = convertToInt(play_time);
        long sum = 0;
        long max = 0;
        int maxStart = 0;

        for (String log : logs) {
            String[] user = log.split("-");
            int start = convertToInt(user[0]);
            int end = convertToInt(user[1]);
            users[start] += 1;
            if (end + 1 < playTime) {
                users[end] -= 1;
            }
            // 누적합 개념을 이용해서 초단위마다 중첩되어 있는 사람 수를 계산
        }

        for (int i = 2; i < playTime; i++) {
            users[i] += users[i-1];
        }

        for (int i = 1; i <= adTime; i++) {
            sum += users[i];
            // 초기값 설정 1초부터 광고시간까지
        }
        max = sum;

        for (int i = adTime+1; i < playTime; i++) {
            sum = sum - users[i-adTime] + users[i];
            // 1초마다 갱신

            if (sum > max) {
                max = sum;
                maxStart = i-adTime+1;
            }
        }

        answer = convertToString(maxStart);

        return answer;
    }

    public int convertToInt(String time) {
        int sum = 0;
        String[] t = time.split(":");

        sum += Integer.parseInt(t[0]) * 3600;
        sum += Integer.parseInt(t[1]) * 60;
        sum += Integer.parseInt(t[2]);
        return sum;
    }

    public String convertToString(int time) {
        StringBuilder sb = new StringBuilder();
        int sec = 3600;

        while (sec != 1) {
            if (time/sec > 9) sb.append(time/sec).append(":");
            else sb.append("0").append(time/sec).append(":");
            time %= sec;
            sec = sec / 60;
        }

        if (time/sec > 9) sb.append(time/sec);
        else sb.append("0").append(time/sec);

        return sb.toString();
    }
}
