import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        long[] edge = new long[n-1];
        long[] vertex = new long[n];
        long min = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < edge.length; i++) {
            edge[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = Long.parseLong(st.nextToken());
        }

        min = vertex[0];
        long tmp = edge[0];

        for (int i = 1; i < n-1; i++) {
            if (vertex[i] < min) {
                // 최솟값 갱신 여태까지 누적된 거리 연산
                answer += tmp * min;
                min = vertex[i];
                tmp = edge[i];
                // 현재 지역의 거리는 확실히 먹을 수 있다.
            } else {
                tmp += edge[i];
            }
        }
        answer += tmp * min;

        System.out.println(answer);
    }
}
