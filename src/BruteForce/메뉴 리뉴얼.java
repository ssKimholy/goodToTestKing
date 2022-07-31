package BruteForce;

import java.util.*;

public class MenuRenual {
    boolean[] visited;
    HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
            // 손님들 주문이 오름차순이라는 보장이 없다.
            // 주문을 오름차순으로 정렬하면 dfs로 조합을 선택해도 중복되는 경우가 없다.
        }

        for (int coursep : course) {
            // 각 길이마다 가장 많은 주문이 들어온 메뉴들을 리스트에 넣는다.
            map = new HashMap<>();
            for (String order : orders) {
                if (order.length() >= coursep) {
                    String[] ord = order.split("");
                    visited = new boolean[ord.length];
                    dfs(ord, 0, 0, coursep, "");
                }
            }

            int max = 0;
            for (Map.Entry<String, Integer> ent : map.entrySet()) {
                max = Math.max(max, ent.getValue());
            }

            for (Map.Entry<String, Integer> ent : map.entrySet()) {
                if (max >= 2 && max == ent.getValue()) {
                    list.add(ent.getKey());
                }
            }
        }

        Collections.sort(list);
        // 정렬 후 리턴

        return list.toArray(new String[list.size()]);
    }

    void dfs(String[] ord, int dep, int idx, int tar, String s) {
        // 조합 알고리즘
        if (dep == tar) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }

        for (int i = idx; i < ord.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(ord, dep+1, i+1, tar, s+ord[i]);
                visited[i] = false;
            }
        }
    }
}

