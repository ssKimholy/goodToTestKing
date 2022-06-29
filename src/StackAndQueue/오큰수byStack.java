package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nge = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nge[i] = -1; // -1로 초기화
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // 처음으로 증가하는 값이 나오면 스택에서 꺼낸 인덱스 값의 오큰수.
                nge[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        for (int a : nge) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}
