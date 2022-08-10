import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                // 연속된 문자가 있다면 스택에 있는 그 문자 제거
                stack.pop();
            } else {
                // 연속된 문자가 아니라면 그대로 스택에 삽입.
                stack.push(c);
            }   
        }
        
        if (stack.isEmpty()) {
            // 과정 후 스택이 비어있다면 성공적 수행
            // 스택을 이용해서 O(n) 의 시간 복잡도로 수행 가능.
            answer = 1;
        } 
        
        return answer;
    }
}
