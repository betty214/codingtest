package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] DP = new int[201][201];

        for (int i = 1; i <= N; i++) {
            DP[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                DP[i][j] = (DP[i][j - 1] + DP[i - 1][j]) % 1000000000;
            }
        }
        System.out.println(DP[N][K]);
    }
}
