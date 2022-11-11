import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        people = new int[N+1][N+1];
        int answer = 1_000_000_000;
        int answerIdx = 0;

        setting(people);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people[a][b] = 1;
            people[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    people[i][j] = Math.min(people[i][j], people[i][k] + people[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                tmp += people[i][j];
            }
            if (answer > tmp) {
                answer = tmp;
                answerIdx = i;
            }
        }

        System.out.println(answerIdx);
    }

    static void setting(int[][] people) {
        for (int i = 1; i < people.length; i++) {
            Arrays.fill(people[i], 1_000_000_000);
        }
    }
}
