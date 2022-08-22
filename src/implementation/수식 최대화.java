package implementation;

import java.util.*;

public class MaxingOper {
    HashMap<String, Integer> priority = new HashMap<>();
    String[] ex = {"+", "-", "*"};
    String[] tmp;
    boolean[] visited;
    long answer;
    public long solution(String expression) {
        answer = 0;

        tmp = new String[3];
        visited = new boolean[3];

        dfs(0, expression);

        return answer;
    }

    void dfs(int dep, String expression) {
        if (dep == 3) {
            // dfs 순열 알고리즘으로 우선순위 믹싱.
            priority.put(tmp[0], 1);
            priority.put(tmp[1], 2);
            priority.put(tmp[2], 3);
            calculate(expression);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[dep] = ex[i];
                dfs(dep+1, expression);
                visited[i] = false;
            }
        }
    }

    public void calculate(String expression) {
        ArrayList<Long> operand = new ArrayList<>();
        ArrayList<String> operator = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(expression, "+-*", true);

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals("+") || temp.equals("-") || temp.equals("*")) {
                operator.add(temp);
            } else {
                operand.add(Long.parseLong(temp));
            }
        }

        int prio = 1;
        while (!operator.isEmpty()) {
            for (int j = 0; j < operator.size(); j++) {
                if (priority.get(operator.get(j)) == prio) {
                    // 우선순위가 높은 것부터 계산 후 해당 인덱스에 다시 삽입.
                    Long a = operand.remove(j); Long b = operand.remove(j);
                    operand.add(j, cal(a, b, operator.get(j)));
                    operator.remove(j);
                    j--;
                }
                // 연산자 리스트가 다 비어지면 answer 갱신.
            }
            prio++;
        }

        answer = Math.max(answer, (Long) Math.abs(operand.get(0)));
    }

    Long cal(Long a, Long b, String op) {
        Long num = 0L;
        switch(op) {
            case "+":
                num = a + b;
                break;
            case "-":
                num = a - b;
                break;
            case "*":
                num = a * b;
                break;
            default:
                break;
        }
        return num;
    }
}
