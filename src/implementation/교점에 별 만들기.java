package implementation;

import java.util.*;

public class MakeStar {
    boolean[] visited;
    HashSet<Point> set = new HashSet<>();
    long xmin = Long.MAX_VALUE; long xmax = Long.MIN_VALUE;
    long ymin = Long.MAX_VALUE; long ymax = Long.MIN_VALUE;
    // x좌표와 y좌표의 최대 최소를 알아야 우리가 만들 배열의 width와 height를 알 수 있다.

    public String[] solution(int[][] lines) {
        String[] answer;
        visited = new boolean[lines.length];

        dfs(0, 0, new int[]{0, 0}, lines);

        long width = xmax-xmin+1; // 만들 배열의 가로길이
        long height = ymax-ymin+1; // 민들 배열의 세로길이

        answer = new String[(int) height];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString()); // 우선 배열 전체를 .로 채우고

        for (Point p : set) {
            long x = p.x-xmin; // 규칙에 따라 좌표 재설정.
            long y = ymax-p.y;

            answer[(int) y] = answer[(int)y].substring(0, (int) x) + "*" + answer[(int) y].substring((int)x + 1);
            // 별 삽입. (substring을 사용하기 때문에 이전에 있던 별도 그대로 있다.)
        }

        return answer;
    }

    public void dfs(int start, int dep, int[] idx, int[][] lines) {
        if (dep == 2) {
            find(lines[idx[0]], lines[idx[1]]);
            return;
        }

        // 조합 알고리즘
        for (int i = start; i < lines.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                idx[dep] = i;
                dfs(i+1, dep+1, idx, lines);
                visited[i] = false;
            }
        }
    }

    public void find(int[] line1, int[] line2) {
        long x = 0, y = 0;
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];

        if (A*D - B*C == 0) {
            return;
        }

        if (((B*F)-(E*D)) % ((A*D)-(B*C)) != 0) { // 정수 교점이 아닌 경우 리턴
            return;
        }

        if (((E*C)-(A*F)) % ((A*D)-(B*C)) != 0) {
            return;
        }
        x = ((B*F)-(E*D)) / ((A*D)-(B*C));
        y = ((E*C)-(A*F)) / ((A*D)-(B*C));

        set.add(new Point(((B*F)-(E*D)) / ((A*D)-(B*C)), ((E*C)-(A*F)) / ((A*D)-(B*C))));

        xmin = Math.min(xmin, x);
        xmax = Math.max(xmax, x);
        ymin = Math.min(ymin, y);
        ymax = Math.max(ymax, y);
    }
}

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
