package BruteForce;

import java.util.*;

public class ThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxGap = 0;

        m = edit(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int playTime = convert(info[1]) - convert(info[0]);

            // 재생시간 순
            if (playTime > maxGap) {
                String playPaper = "";
                String paper = edit(info[3]);
                for (int i = 0; i < playTime; i++) {
                    playPaper += paper.charAt(i%paper.length());
                }

                if (playPaper.contains(m)) {
                    maxGap = playTime;
                    answer = info[2];
                }
            }
        }

        return answer;
    }

    // 시 -> 분 변환
    public int convert(String time) {
        String[] ti = time.split(":");
        int hour = Integer.parseInt(ti[0]);
        int minute = Integer.parseInt(ti[1]);

        return hour*60 + minute;
    }

    // #음들은 소문자로 치환. 그래야 한문자로 바꿀 수 있다.
    public String edit(String m) {
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        return m;
    }
}