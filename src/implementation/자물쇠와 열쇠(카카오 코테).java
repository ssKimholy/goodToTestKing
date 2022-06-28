package implementation;

import java.util.*;
import java.io.*;

public class KeyAndLock {
    static int[][] key;
    static int[][] lock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        key = new int[M][M];
        lock = new int[N][N];

        for (int i = 0; i < key.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < key.length; j++) {
                key[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < lock.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < lock.length; j++) {
                lock[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(hold(key, lock));
    }

    static boolean hold(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int len = M + N - 1; // padding배열의 크기
        int off = M-1; // padding배열 속 lock시작 주소 (lock주소에 있는 값만 보고 true false 판단.)

        for (int p = 0; p < len; p++) {
            for (int q = 0; q < len; q++) {
                for (int i = 0; i < 2; i++) {
                    // i = 0이면 원래 키로 check
                    // i = 1이면 뒤집은 키로 check
                    int[][] padding = new int[len*2 + N][len*2 + N];
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            padding[off+k][off+l] = lock[k][l];
                        }
                    } // padding배열은 한번 check할때마다 초기화 되어야 한다.

                    if (i == 0) {
                        for (int k = 0; k < M; k++) {
                            for (int l = 0; l < M; l++) {
                                padding[p+k][q+l] += key[k][l];
                            } // key값과 lock값을 더해 padding속 lock주소에 있는 값이 1이 아닌 값(0 or 2)이 있다면, false
                        }
                    } else {
                        for (int k = 0; k < M; k++) {
                            for (int l = 0; l < M; l++) {
                                padding[p+k][q+l] += key[M-1-k][l];
                            }
                        }
                    }
                    if (check(padding, off, N)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean check(int[][] padding, int off, int N) {
        for (int i = off; i < off+N; i++) {
            for (int j = off; j < off+N; j++) {
                if (padding[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
