package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1010 {
    static int[][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            DP=new int[M+1][N+1];
            for(int j=1;j<=M;j++){
                DP[j][1]=j;
            }
            System.out.println(DFS(M,N));
        }
    }static int DFS(int m,int n){
        if(n==1){
            return DP[m][n];
        }if(n == m || n == 0) {
            return DP[m][n] = 1;
        }
        if(DP[m][n]==0){
            DP[m][n]=DFS(m-1,n-1)+DFS(m-1,n);
        }
        return DP[m][n];
    }
}
