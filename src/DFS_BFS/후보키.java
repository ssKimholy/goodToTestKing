package DFS_BFS;

import java.util.*;

public class CandidateKey {
    ArrayList<String> candidKey = new ArrayList<>();
    int column = 0;
    boolean[] visited;

    public int solution(String[][] relation) {
        int answer = 0;
        column = relation[0].length;
        visited = new boolean[column];

        for (int i = 1; i <= column; i++) {
            // 1부터 column까지 조합을 다 탐색해본다.
            dfs(relation, i, 0, "", 0);
        }

        answer = candidKey.size();

        return answer;
    }

    void dfs(String[][] relation, int num, int dep, String str, int start) {
        if (dep == num) {
            // 조합이 완성된경우 체크
            check(str, relation);
            return;
        }

        for (int i = start; i < column; i++) {
            // dfs 조합 알고리즘
            if (!visited[i]) {
                visited[i] = true;
                dfs(relation, num, dep+1, str+String.valueOf(i), i+1);
                visited[i] = false;
            }
        }
    }

    void check(String str, String[][] relation) {
        String[] st = str.split("");
        HashSet<String> set = new HashSet<>();

        // 최소성 체크
        for (String s : candidKey) {
            String[] candid = s.split("");
            int cnt = 0;
            for (String key : candid) {
                // 기존에 있는 후보키가 조합에 포함되는지 확인.
                if (str.contains(key)) cnt++;
            }
            if (cnt == candid.length) return;
        }

        // 유일성 체크
        for (int i = 0; i < relation.length; i++) {
            String tmp = "";
            for (int j = 0; j < st.length; j++) {
                tmp += relation[i][Integer.parseInt(st[j])];
            }
            // 중복확인
            if (set.contains(tmp)) {
                return;
            } else {
                set.add(tmp);
            }
        }

        candidKey.add(str);
    }
}
