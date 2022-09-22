import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] stuff;
    static int[] bag;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        stuff = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K+1];
        for (int i = 0; i < stuff.length; i++) {
            int w = stuff[i][0];
            int v = stuff[i][1];
            for (int j = K; j >= 0; j--) {
                if (j - w >= 0) {
                    dp[j] = Math.max(dp[j], dp[j-w] + v);
                }
            }
        }

        System.out.println(dp[K]);
    }
}
