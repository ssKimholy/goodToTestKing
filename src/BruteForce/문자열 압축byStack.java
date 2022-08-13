package BruteForce;

import java.util.*;

public class CompressStr {
    StringBuilder sb;
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length(); i++) {
            sb = new StringBuilder();
            compress(i, s);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    void compress(int len, String s) {
        Stack<String> stack = new Stack<>();
        int idx = 0;

        while (idx < s.length()) {
            if (idx + len > s.length()) break;

            String str = s.substring(idx, idx+len);

            if (!stack.isEmpty() && !stack.peek().equals(str)) {
                int cnt = 1;
                String st = stack.pop();
                while (!stack.isEmpty() && stack.peek().equals(st)) {
                    cnt++;
                    stack.pop();
                }

                if (cnt == 1) {
                    sb.append(st);
                } else {
                    sb.append(cnt).append(st);
                }
            }

            stack.push(str);
            idx += len;
        }

        if (!stack.isEmpty()) {
            String st = stack.pop();
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek().equals(st)) {
                cnt++;
                stack.pop();
            }

            if (cnt == 1) {
                sb.append(st);
            } else {
                sb.append(cnt).append(st);
            }
        }

        sb.append(s.substring(idx, s.length()));
    }
}
