package DFS_BFS;

class WordChange {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words, int dep) {
        int che = check(begin, target);
        // 현재 단어와 타겟 단어와의 일치성 체크
        if (che == target.length()) {
            // 만약 현재 단어와 타겟 단어가 일치한다면 현재까지의 탐색길이 반환
            answer = dep;
            return;
        } else if (che == target.length() - 1) {
            // 현재 단어와 타겟 단어 사이의 오차가 알파벳 하나 차이라면 나머지 words배열 원소를 전체 탐색해서 타겟 단어가 있는지 확인 후 길이 1증가 시키고 리턴.
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(target)) {
                    answer = dep + 1;
                    return;
                }
            }
        }

        // dfs 탐색
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            if (!visited[i]) {
                count = check(words[i], begin);
                 // 방문하지 않은 단어들 중에서 현재 단어와 알파벳 하나 차이나는 단어를 찾고
                // 그 단어를 현재 단어로 갱신 후 dfs

                if (count == begin.length()-1) {
                    visited[i] = true;
                    dfs(words[i], target, words, dep+1);
                    return;
                    // return을 달아주는 이유는 갱신한 단어로 dfs 탐색 후 다시 전 단어로 dfs를 실행하게 되면
                    // answer값이 변경될 가능성이 높기 때문에 반드시 return을 달아주어 함수를 끝내야 한다.
                }
            }

        }
    }

    public int check(String word, String target) {
        // 일치성 체크
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
