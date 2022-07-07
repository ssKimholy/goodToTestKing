package DFS_BFS;

import java.util.*;

class WordChange_BFS {
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        que.offer(begin);

        while(!que.isEmpty()) {
            String word = que.poll();
            int che = check(word, target);
            if (che == target.length()) {
                return answer;
            } else if (che == target.length() - 1) {
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(target)) {
                        return answer+1;
                    }
                }
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int count = check(words[i], word);

                    if (count == begin.length()-1) {
                        que.offer(words[i]);
                        answer++;
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        return 0;
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
