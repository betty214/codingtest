package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2098 {
    static int sum,n;
    static int [][]W,DP;
    static final int INF = 11000000;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2098.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum=(1<<n)-1;
        W=new int[n][n];
        DP=new int[n][sum];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                W[i][j]=Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<sum;j++){
                DP[i][j]=INF;
            }
        }
        System.out.println(DFS(0,1));
    }static int DFS(int now, int bit){
        if(bit==sum){
            if(W[0][now]==0) return INF;
            else return W[0][now];
        }
        if(DP[now][bit]!=INF) return DP[now][bit];
        for(int i=0;i<n;i++){
            int next=bit|(1<<i);
            if((next|bit)!=bit && W[i][now]!=0){
                DP[now][bit]=Math.min(DP[now][bit],DFS(i,next)+W[i][now]);
            }
        }
        return DP[now][bit];
    }
}
