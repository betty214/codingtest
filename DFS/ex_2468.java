package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_2468 {
    static int[][] land;
    static boolean[][] visited;
    static int N, count, answer;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        int max = 0;
        int min=101;
        answer = 0;
        boolean flag= true;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                if (land[i][j] > max) {
                    max = land[i][j];
                }if (land[i][j] < min) {
                    min = land[i][j];
                }if(land[0][0] != land[i][j]) {
                    flag = false;
                }
            }
        }
        for (int i = min; i < max; i++) {
            visited = new boolean[N][N];
            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && land[j][k] > i) {
                        safe(i, j, k);
                        count++;
                    }
                }
            }
            if (answer < count) {
                answer = count;
            }
        }
        if(flag){
            System.out.println(1);
        }else {
            System.out.println(answer);
        }
    }

    static void safe(int rain, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (check(cx, cy)) {
                if (!visited[cx][cy] && land[cx][cy] > rain) {
                    safe(rain, cx, cy);
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (x >= N || y >= N || x < 0 || y < 0) {
            return false;
        } else {
            return true;
        }
    }
}
