import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder sb = new StringBuilder();
        int len = N.length();
        long total = 0;
        int[] count = new int[10];

        for (int i = 0; i < len; i++) {
            int tmp = Integer.parseInt(N.substring(i, i+1));
            count[tmp]++; // 각 숫자가 몇 번 카운트 되는지 센다. (나중에 내림차순으로 가장 큰 값을 만들기 위해.)
            total += tmp; // 3의 배수는 각 자리 수를 더해도 3의 배수다. (정수론의 기본)
        }

        if (!N.contains("0") || (total % 3) != 0) { // 30의 배수니까 적어도 0이 하나는 포함되어야 하고, 앞에서 나온 정수론 조건까지 확인한다.
            System.out.println(-1);
        } else {
            for (int i = 9; i >=0; i--) {
                while (count[i] -- > 0) {
                    sb.append(i);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
