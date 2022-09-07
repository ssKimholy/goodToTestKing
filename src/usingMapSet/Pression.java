package usingMapSet;

import java.util.*;

public class Pression {
    HashMap<String, Integer> dic = new HashMap<>();

    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 0; int pre= 0; int num = 1;
        String preS = "", s = "";

        for (num = 1; num <= 26; num++) {
            dic.put(Character.toString((char) num+64), num);
        } // A~Z까지 매핑

        while (idx < msg.length()) {
            preS = msg.substring(pre, idx); // 전 문자열
            s = msg.substring(pre, idx+1); // 현 문자열
            if (dic.containsKey(s)) {
                // 현 문자열이 dic에 있다면 인덱스 증가
                idx++;
                continue;
            } else {
                // 현 문자열이 dic에 없다면 전 문자열 색인번호 삽입 후 현 문자열 dic에 삽입
                answer.add(dic.get(preS));
                dic.put(s, num++);
                pre = idx;
            }
        }

        if (dic.containsKey(s)) {
            answer.add(dic.get(s));
        }

        return answer.stream().mapToInt(i -> i).toArray();

    }
}