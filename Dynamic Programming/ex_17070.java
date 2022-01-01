package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17070 {
    static int[][]pipe;
    static int[][][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pipe=new int[N+1][N+1];
        DP=new int[N+1][N+1][3];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                pipe[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP[1][2][0] = 1;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if(pipe[x][y]==1)
                    continue;
                DP[x][y][0] += DP[x][y - 1][0] + DP[x][y - 1][2];
                DP[x][y][1] += DP[x - 1][y][1] + DP[x - 1][y][2];
                if (pipe[x - 1][y] == 0 && pipe[x][y - 1] == 0) {
                    DP[x][y][2] += DP[x - 1][y - 1][0] + DP[x - 1][y - 1][1] + DP[x - 1][y - 1][2];
                }
            }
        } System.out.println(DP[N][N][0] + DP[N][N][1] + DP[N][N][2]);

    }
}
