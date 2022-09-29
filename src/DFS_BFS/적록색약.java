import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int answer = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < map.length; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

        wholebfs();

        sb.append(answer).append(" ");

        visited = new boolean[n][n];
        answer = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        wholebfs();

        sb.append(answer);

        System.out.println(sb.toString());
    }

    private static void wholebfs() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    answer++;
                }
            }
        }
    }

    static void bfs(int y, int x, char color) {
        Queue<int[]> que = new LinkedList<>();
        visited[y][x] = true;
        que.offer(new int[]{y, x});

        while (!que.isEmpty()) {
            int[] k = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = k[0] + dy[i];
                int nx = k[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= visited.length || nx >= visited.length || visited[ny][nx]
                || color != map[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                que.offer(new int[]{ny, nx});
            }
        }
    }
}
