package DFS_BFS;

import java.util.*;

public class SheepAndWolf {
    ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    int answer = 0;
    public int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(0, list, 0, 0, info);

        return answer;
    }

    void dfs(int node, ArrayList<Integer> list, int sheep, int wolf, int[] info) {
        if (info[node] == 0) sheep++;
        else wolf++;

        if (sheep <= wolf) {
            return;
        } // 더 이상 진행할 수 없는 경우
        answer = Math.max(answer, sheep);

        ArrayList<Integer> nextRoute = new ArrayList<>();
        nextRoute.addAll(list);
        // 참조값 복사를 방지하기 위해 리스트를 하나 더 만들어 값만을 복사하게 만든다.
        nextRoute.addAll(tree.get(node));
        // 현재 부모의 자식들도 다음 경로에 포함.
        nextRoute.remove(Integer.valueOf(node)); // 현재 부모 노드를 dfs과정에서 다시 방문치 않게 다음경로에서 삭제해준다.

        for (int i : nextRoute) {
            dfs(i, nextRoute, sheep, wolf, info);
        }
    }
}
