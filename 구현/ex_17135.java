package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17135 {
    static int[][] castle;
    static int N, M, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < M; j++) {
                if (i >= j) continue;
                for (int k = 2; k < M; k++) {
                    if (j >= k) continue;
                    int[] archer = {i, j, k};
                    int enemy = turn(archer);
                    System.out.println(i + " " + j + " " + k + " :" + enemy);
                    if (answer < enemy) {
                        answer = enemy;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static int turn(int[] archer) {
        int enemy = 0;
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = castle[i][j];
            }
        }
        for (int k = N; k > 0; k--) {
            int end = k - D;
            if (end < 0) {
                end = 0;
            }
            for (int t = 0; t < 3; t++) {
                Loop1 :
                for (int j = 0; j < M; j++) {
                    for (int i = k - 1; i >= end; i--) {
                        if (temp[i][j] == 0) continue;
                        if ((k - i) + Math.abs(archer[t] - j) <= D) {
                            enemy++;
                            temp[i][j] = 0;
                            break Loop1;
                        }
                    }
                }
            }
        }

        return enemy;
    }

}
