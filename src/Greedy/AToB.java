import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        dfs(0, String.valueOf(B), String.valueOf(A));

        if (answer == 1_000_000_000) {
            System.out.println("-1");
        } else {
            System.out.println(answer+1);
        }
    }

    static void dfs(int count, String target, String current) {
        long crt1 = Long.parseLong(current);

        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        if (crt1 * 2 <= Long.parseLong(target)) {
            dfs(count+1, target, String.valueOf(crt1*2));
        }

        if ((current+"1").length() < 10) {
            dfs(count+1, target, current+"1");
        }
    }
}
