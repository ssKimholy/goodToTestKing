package StackAndQueue;

import java.util.*;

public class TurnBrace {
    HashMap<Character, Character> pair = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        pair.put(']', '[');
        pair.put(')', '(');
        pair.put('}', '{');
        // 수작업 방지용 페어

        for (int i = 0; i < s.length(); i++) {
            if (turn(s, i)) answer++;
        }

        return answer;
    }

    public boolean turn(String s, int x) {
        String string = s.substring(x, s.length()) + s.substring(0, x);
        // 왼쪽으로 회전이니까 x번째 인덱스부터 끝까지 붙이고 그 다음에 0번째부터 x번째까지 붙인다.

        return check(string);
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        // 주의해야 할 것은 "[(])" 같은 것은 올바른 괄호가 아니다. (무조건 후입선출)

        for (char c : str) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char couple = stack.pop();
                if (couple != pair.get(c)) return false;
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }

}