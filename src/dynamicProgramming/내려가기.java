import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] maxDp;
    static int[] minDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        maxDp = new int[3];
        minDp = new int[3];
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int tmpA = maxDp[0]; // 전 배열의 값을 받아올 변수 필요.
            int tmpB = maxDp[1];
            int tmpC = maxDp[2];
            maxDp[0] = Math.max(tmpA, tmpB) + a; // dp알고리즘
            maxDp[1] = Math.max(tmpA, Math.max(tmpB, tmpC)) + b;
            maxDp[2] = Math.max(tmpB, tmpC) + c;

            tmpA = minDp[0];
            tmpB = minDp[1];
            tmpC = minDp[2];
            minDp[0] = Math.min(tmpA, tmpB) + a;
            minDp[1] = Math.min(tmpA, Math.min(tmpB, tmpC)) + b;
            minDp[2] = Math.min(tmpB, tmpC) + c;
        }

        max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(max + " " + min);
    }


}

