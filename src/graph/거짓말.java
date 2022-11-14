import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent; // union-find에 필요한 부모 확인 배열
    static boolean[] knowTrue; // 진실을 알고 있는 사람들
    static String[] party; // 파티 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = M;
        parent = new int[N+1];
        knowTrue = new boolean[N+1];
        party = new String[M];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            // parent 배열 초기화
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        while (num-- > 0) {
            parent[Integer.parseInt(st.nextToken())] = 0;
            // 진실을 알고 있는 사람의 부모는 무조건 0
        }

        for (int i = 0; i < M; i++) {
            String partyPeople = br.readLine();
            party[i] = partyPeople;
            String[] partyStr = partyPeople.split(" ");
            for (int j = 1; j <= Integer.parseInt(partyStr[0]); j++) {
                for (int k = j+1; k <= Integer.parseInt(partyStr[0]); k++) {
                    int pre = Integer.parseInt(partyStr[j]);
                    int post = Integer.parseInt(partyStr[k]);
                    if (!find(pre, post)) {
                        union(pre, post);
                        getParent(pre);
                        getParent(post);
                    }
                    // union-find 알고리즘 수행
                    // 한 파티에 있던 사람들은 무조건 부모가 하나로 수렴
                }
            }
        }

        for (int i = 1; i < parent.length; i++) {
            if (getParent(i) == 0) {
                // 만약 부모가 0인 사람이 있다면 진실을 아는 사람이니 true
                knowTrue[i] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] partyStr = party[i].split(" ");
            for (int j = 1; j <= Integer.parseInt(partyStr[0]); j++) {
                // 파티가 진실을 아는 파티인지 확인
                // 진실을 아는 파티라면 거짓말을 할 수 없으니 answer를 하나 뺀다.
                if (knowTrue[Integer.parseInt(partyStr[j])]) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static int getParent(int i) {
        // 부모를 찾고 갱신하는 함수
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = getParent(parent[i]);
    }

    static void union(int x, int y) {
        // 두 노드의 부모를 합치는 함수

        x = getParent(x);
        y = getParent(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static boolean find(int x, int y) {

        // 두 노드의 부모가 같은지 보는 함수.

        x = getParent(x);
        y = getParent(y);

        if (x == y) {
            return true;
        } else {
            return false;
        }

    }
}
