package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2098 {
    static int [][]travel,DP;
    static int N,sum;
    static final int INF = 11000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        travel =new int[N][N];
        sum=(1 << N) - 1;
        DP=new int[sum][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                travel[i][j]=now;
            }
            for(int j=0;j<sum;j++){
                DP[j][i]=INF;
            }
        }
        System.out.println(DFS(0,1));

    }static int DFS(int start, int bitm){
        if(bitm==sum){
            if(travel[0][start]==0) return INF;
            return travel[0][start];
        }
        if(DP[bitm][start]!=INF){
            return DP[bitm][start];
        }
        for(int i = 0; i < N; i++) {
            if((bitm & (1 << i)) == 0 && travel[i][start] != 0) {
                DP[bitm][start] = Math.min(DP[bitm][start], DFS(i, bitm | (1 << i)) + travel[i][start]);
            }
        }
        return DP[bitm][start];
    }
}
