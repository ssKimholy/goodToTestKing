import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            
            if (str.equals(" ")) {
                isFirst = true;
                answer += str;
            } else {
                answer += isFirst ? str.toUpperCase() : str.toLowerCase();
                isFirst = false;
            }
            
        }
        
        return answer;
    }
}
