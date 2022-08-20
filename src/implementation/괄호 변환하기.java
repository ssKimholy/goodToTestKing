package implementation;

import java.util.*;

public class Transition {
    public String solution(String p) {
        String answer = "";

        boolean isRight = verify(p);

        if (isRight) answer = p; // p자체가 올바른 괄호 문자열이라면 그냥 리턴
        else {
            // 아니라면 조작
            answer = operation(p);
        }

        return answer;
    }

    String operation(String p) {
        if (p.length() == 0) return ""; // 공문자열이면 공문자열 리턴.
        String u = "", v = "";
        int o1 = 0, o2 = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') o1++;
            else o2++;

            u += c;

            if (o1 == o2) {
                break;
            }
        }
        v = p.substring(o1+o2); // u, v 나누기

        if (verify(u)) {
            // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
            //    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + operation(v);
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            //    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //    4-3. ')'를 다시 붙입니다.
            //    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            //    4-5. 생성된 문자열을 반환합니다.
            String str = "(" + operation(v) + ")";
            for (int i = 1; i < u.length()-1; i++) {
                str += u.charAt(i) == '(' ? ')' : '(';
            }
            return str;
        }
    }

    boolean verify(String p) {
        char[] c = p.toCharArray();
        Queue<Character> que = new LinkedList<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') que.offer('(');
            else {
                if (que.isEmpty()) {
                    return false;
                }
                que.poll();
            }
        }

        if (!que.isEmpty()) return false;

        return true;

    }
}
