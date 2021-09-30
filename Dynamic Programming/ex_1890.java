package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1890 {
    static int [][]game;
    static long [][]DP;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        game = new int[N][N];
        DP = new long[N][N];
        for(int i=0;i<DP.length;i++){
            Arrays.fill(DP[i], 0);
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP[0][0]=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==N-1&&j==N-1)
                    continue;
                int jump=game[i][j];
                if(i+jump<N){
                    DP[i+jump][j]+=DP[i][j];
                }if(j+jump<N){
                    DP[i][j+jump]+=DP[i][j];
                }
            }
        }
        System.out.println(DP[N-1][N-1]);
    }
}
