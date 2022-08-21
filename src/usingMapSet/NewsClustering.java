package usingMapSet;

import java.util.*;

public class NewsClustering {
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    HashSet<String> set1 = new HashSet<>();
    HashSet<String> set2 = new HashSet<>();

    public int solution(String str1, String str2) {
        int answer = 0;
        int intersection = 0;
        int union = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        makeSet(str1, str2);

        for (String s : set1) {
            if (set2.contains(s)) {
                // 교집합을 체크 후 둘 사이 min값을 교집합에 합집합에는 max값을.
                intersection += Math.min(map1.get(s), map2.get(s));
                union += Math.max(map1.get(s), map2.get(s));
            } else {
                // 교집합에 포함되지 않는 합집합은 개수만큼만
                union += map1.get(s);
            }
        }
        for (String s : set2) {
            if (!set1.contains(s)) {
                // 교집합은 이미 앞에서 체크했으니 합집합만 체크한다.
                union += map2.get(s);
            }
        }

        if (union == 0) return 65536;

        double jacard = (double) intersection / union;
        answer = (int) (jacard * 65536.0);
        return answer;
    }

    public void makeSet(String str1, String str2) {
        for (int i = 0; i < str1.length()-1; i++) {
            if (!Character.isLetter(str1.charAt(i)) || !Character.isLetter(str1.charAt(i+1))) {
                continue; // 알파벳 2자리만 추출.
            }

            String str = str1.substring(i, i+2);

            set1.add(str);
            map1.put(str, map1.getOrDefault(str, 0) + 1); // 개수를 세어준다.
        }

        for (int i = 0; i < str2.length()-1; i++) {
            if (!Character.isLetter(str2.charAt(i)) || !Character.isLetter(str2.charAt(i+1))) {
                continue;
            }

            String str = str2.substring(i, i+2);

            set2.add(str);
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
    }
}
