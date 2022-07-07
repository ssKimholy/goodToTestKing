package DFS_BFS;

class WordChange_2 {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        return answer;
    }

    public void dfs(String begin, String target, String[] words, int dep) {
        if (begin.equals(target)) {
            // 최솟값 갱신
            answer = Math.min(answer, dep);
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int count = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        count++;
                    }
                } // 현재 단어와 알파벳 하나 차이인 원소를 기준으로 dfs.
                // 모든 경우의 수를 확인하기 위해 조합 알고리즘
                if (count == begin.length() - 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, dep+1);
                    visited[i] = false;
                }
            }
        }
    }
}
