package StackAndQueue;

import java.util.Stack;

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;

        for (int i = 0; i < len; i++) {
            // 전형적인 스택 활용 풀이(오큰수 류)
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 처음으로 가격이 떨어지는 순간을 초착해서 그 거리가 얼마나 떨어져 있는지 확인.
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 스택에 남아있는 원소들은 끝가지 가격이 떨어지지 않는 원소들이다.
            answer[stack.peek()] = len - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}
