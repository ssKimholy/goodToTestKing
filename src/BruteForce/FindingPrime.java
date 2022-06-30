package BruteForce;

class FindingPrime {
    static boolean[] prime = new boolean[10000000]; // 소수판별 배열
    static boolean[] answer = new boolean[10000000]; // 정답 배열
    static int N = 0;
    static boolean[] visit; // dfs 방문 배열
    public void primeCal() { // 에라토스테네스의 체 Algorithm
        prime[0] = prime[1] = true;
        for (int i = 2; i*i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i*i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public void dfs(String[] number, int len, String s) {
        if (s.length() == len) { // 만약 원하는 길이의 문자열이 완성됐으면, 소수인지 판별 후
            // 배열 수정
            if (!prime[Integer.parseInt(s)]) {
                answer[Integer.parseInt(s)] = true;
            }
            return;
        }

        for (int k = 0; k < number.length; k++) {
            // dfs 순열 Algorithm.
            if (!visit[k]) {
                visit[k] = true;
                dfs(number, len, s+number[k]);
                visit[k] = false;
            }
        }
    }

    public int solution(String numbers) {

        primeCal();
        String[] number = numbers.split("");
        visit = new boolean[number.length];
        for (int i = 1; i <= number.length; i++) {
            dfs(number, i, "");
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                N++;
            }
        }

        return N;
    }
}