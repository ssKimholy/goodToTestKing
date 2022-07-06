package DFS_BFS;

class TargetNumber_dfs {
    static int answer = 0;
    static int[] number;
    static boolean[] visit;
    public int solution(int[] numbers, int target) {
        number = new int[numbers.length];
        visit = new boolean[numbers.length];
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            number[i] = numbers[i];
            count += numbers[i];
        } // 원소를 다 더한 값이 target이면, 더 이상 경우의 수를 따질 필요가 없다.
        if (count == target) {
            return 1;
        }

        for (int i = 1; i < number.length; i++) {
            dfs(0, 0, i, target);
        } // n개 중에서 몇개를 -로 만들건지 결정

        return answer;
    }

    public void dfs(int start, int dep, int p, int target) {
        if (dep == p) { // 정해진 dep만큼 -로 만들었다면 합을 구하고
            int sum = 0; // 합이 target이면 경우의 수 하나 증가.
            for (int i = 0; i < number.length; i++) {
                sum += number[i];
            }
            if (sum == target) {
                answer++;
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            // 조합이 아닌 순열이기에 스타트 지점을 항상 달리해야 한다.
            // 그래야 순서를 맞출 수 있다. (중복제거)
            if (!visit[i]) {
                visit[i] = true;
                number[i] = -1*number[i];
                dfs(i, dep+1, p, target);
                number[i] = -1*number[i];
                visit[i] = false;
            }
        }
    }
}
