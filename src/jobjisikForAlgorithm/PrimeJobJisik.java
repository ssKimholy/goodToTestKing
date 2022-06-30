package jobjisikForAlgorithm;

public class PrimeJobJisik {
    public static void main(String[] args) {
        int n = 100000;

    }

    static boolean prime_1(int n) {
        // 방법1, 반복문을 통해 n미만의 수들 중으로 나누었을때 나누어 떨어지면 소수X, 아니면 소수O.
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static boolean prime_2(int n) {
        // 방법2, 반복문을 통해 rootN까지의 수들 중으로 나누었을 때, 나누어 떨어지면 소수X, 아니면 소수O.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static boolean[] prime_3(int n) {
        // 방법3, 에라토스테네스의 체로 풀기.
        // 걸러지지 않으면 소수.
        boolean[] prime = new boolean[n];

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        return prime;
    }
}
