package StackAndQueue;

import java.util.*;

public class HateSameNum {
    public int[] solution(int[] arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                // 중복제거
                stack.push(arr[i]);
            }
        }
        answer = new int[stack.size()];
        for (int i = answer.length-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}