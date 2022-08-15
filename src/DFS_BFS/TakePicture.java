package DFS_BFS;

public class TakePicture {
    boolean[] visited;
    char[] arr; // 순열 데이터를 담을 배열
    int answer;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}; // 카카오 친구들
    public int solution(int n, String[] data) {
        answer = 0;

        visited = new boolean[friends.length];
        arr = new char[friends.length];

        dfs(0, data);

        return answer;
    }

    void dfs(int dep, String[] data) {
        // 순열 알고리즘. (기억하자 반복문에서 스타트 지점을 설정한다면 조합, 스타트 설정이 없다면 순서까지 고려하는 순열이다.)
        if (dep == arr.length) {
            if (check(arr, data)) answer++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[dep] = friends[i];
                dfs(dep+1, data);
                visited[i] = false;
            }
        }
    }

    boolean check(char[] arr, String[] data) {
        String str = "";

        for (int j = 0; j < arr.length; j++) str += arr[j];

        for (String s : data) {
            char[] con = s.toCharArray();
            char from = con[0];
            char to = con[2];
            char dir = con[3];
            char num = con[4];
            int p = str.indexOf(from);
            int q = str.indexOf(to);

            switch(dir) {
                // 조심해야 할 것은 간격은 인덱스 차보다 1 작다는 것(간격이 0이면 인덱스 차는 1).
                case '=':
                    if ((int) Math.abs(p-q) != num - '0' + 1) return false;
                    break;
                case '>':
                    if ((int) Math.abs(p-q) <= num - '0' + 1) return false;
                    break;
                case '<':
                    if ((int) Math.abs(p-q) >= num - '0' + 1) return false;
                    break;
                default:
                    break;
            }
        }

        return true;
    }
}