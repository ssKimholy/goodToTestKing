import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Pair> men = new PriorityQueue<>();
            StringTokenizer st;
            int prevQ = N+1;
            int count = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                Pair pair = new Pair(p, q);
                men.add(pair);
            }

            while (!men.isEmpty()) {
                Pair pair = men.poll();
                if (prevQ > pair.q) {
                    // p는 정렬된 상태이기 때문에 뒤에 있는 수들은 이긴다. 
                    // 문제는 q값이 앞에 있는 수들의 q값보다 작아야 한다는 것이다.
                    // 그래서 q의 최솟값을 갱신해가며 합격할 수 있는 신입사원의 수를 센다.
                    count++;
                    prevQ = pair.q;
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb.toString());
    }
}

// 쌍 class
class Pair implements Comparable<Pair> {
    int p;
    int q;

    public Pair(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public int compareTo(Pair other) {
        // 우선 p값을 기준으로 정렬한 뒤 n번만 q값을 비교하면 된다.
        return this.p - other.p;
    }
}
