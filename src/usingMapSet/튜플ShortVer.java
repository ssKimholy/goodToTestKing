import java.util.*;

class Solution {
    LinkedHashSet<String> set = new LinkedHashSet<>();
    public int[] solution(String s) {
        int[] answer;
        String[] str;
        
        str = s.replace("{", " ").replace("}", " ").trim().split(" , ");
        // 우선 중괄호들을 모두 공백으로 replacing하고 맨앞과 맨뒤는 중괄호가 두 개씩 있기 때문에 앞 뒤 공백을 잘라야 한다. 그래서 trim()을 썼다.
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // 길이 순서로 정렬 후
            }
        }); 
        
        answer = new int[str.length];
        int idx = 0;
        for (String st1 : str) {
            for (String st2 : st1.split(",")) {
                if (!set.contains(st2)) {
                    // 그대로 set으로 중복확인 후 배열에 삽입.
                    set.add(st2);
                    answer[idx++] = Integer.parseInt(st2);
                }
            }
        }
        
        return answer;
    }
}
