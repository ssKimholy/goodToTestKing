import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    public int[] solution(String s) {
        int[] answer;
        int idx = 0;
        boolean isClose = true;
        String num = "";
        
        for (int i = 1; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (c == '{') {
                list.add(new ArrayList<>());
                isClose = false;
            } else if (c == '}') {
                list.get(idx).add(Integer.parseInt(num));
                idx++;
                num = "";
                isClose = true;
            } else {
                if (Character.isDigit(c)) {
                    num += c;
                } else {
                    if (!isClose) {
                        list.get(idx).add(Integer.parseInt(num));
                        num = "";
                    }
                }
            }
        }
        
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> li1, ArrayList<Integer> li2) {
                return li1.size() - li2.size();
            }
        });
        
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (!set.contains(list.get(i).get(j))) {
                    set.add(list.get(i).get(j));
                    break;
                }
            }
        }
        
        
        idx = 0;
        answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            answer[idx] = iter.next();
            idx++;
        }
         
        return answer;
    }
}
