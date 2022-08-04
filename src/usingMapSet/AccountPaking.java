package usingMapSet;

import java.util.*;

public class AccountPaking {
    HashMap<String, Integer> in = new HashMap<>();
    TreeMap<String, Integer> time = new TreeMap<>();
    // key가 정렬된 상태로 map을 쓰고 싶다면 Treemap을 써야한다.

    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        for (String record : records) {
            String[] rec = record.split(" ");

            if (rec[2].equals("IN")) {
                in.put(rec[1], convert(rec[0]));
            } else {
                time.put(rec[1], time.getOrDefault(rec[1], 0) + (convert(rec[0]) - in.get(rec[1])));
                in.remove(rec[1]);
            }
        }

        for (Map.Entry<String, Integer> ent : in.entrySet()) {
            // 나간 기록이 없는 차들은 23:59에 나간걸로 계산
            time.put(ent.getKey(), time.getOrDefault(ent.getKey(), 0) + ((60*23 + 59) - in.get(ent.getKey())));
        }

        answer = new int[time.size()];

        int idx = 0;
        for (int all : time.values()) {
            answer[idx] = fees[1];
            if (all > fees[0]) {
                answer[idx] += (int) Math.ceil((double) (all - fees[0]) / fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }

    int convert(String str) {
        // 시*60 + 분으로 절대 시간으로 convert
        String[] s = str.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);

        return hour * 60 + minute;
    }
}