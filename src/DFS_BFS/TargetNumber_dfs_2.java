package DFS_BFS;

class TargetNumber_dfs_2 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);

        return answer;
    }

    public void dfs(int[] numbers, int dep, int sum, int target) {
        // 그물 알고리즘 (일단 2개 혹은 3개씩 던져놓고, 조건을 개입하는 알고리즘)
        if (dep == numbers.length) {
            // 현재 인덱스가 끝이라면
            if (sum == target) {
                // 그 합이 target이면 경우의 수 하나 증가
                answer++;
            }
            return;
        } else {
            dfs(numbers, dep+1, sum + numbers[dep], target); // 현재 인덱스에 있는 값을 더할지 뺄지
            dfs(numbers, dep+1, sum - numbers[dep], target);
        }
    }
}