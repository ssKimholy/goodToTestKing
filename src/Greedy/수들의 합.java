import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sub = 1;
        long count = 0;

        while (S != 0) {
            if (S == sub) {
                // 끝나는 지점
                count += 1;
                break;
            }
            if (S - sub <= sub) {
                // 더 이상 뺄 수가 없는 경우
                // 뒤로 물리고 S가 아예 0이 될 때까지 반복.
                sub++;
                continue;
            }
            S -= sub;
            count++;
            sub++;
        }

        System.out.println(count);
    }
}
