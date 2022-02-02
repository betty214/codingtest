package day9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_7579 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day9/7579.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]app=new int[N][2];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            app[i][0]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int total=0;
        for(int i=0;i<N;i++){
            app[i][1]=Integer.parseInt(st.nextToken());
            total+=app[i][1];
        }
        int[][]DP=new int[N][total+1];
        for(int i=0;i<=total;i++){
            if(i>=app[0][1]) DP[0][i]=app[0][0];
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<=total;j++){
                int nowCost=app[i][1];
                DP[i][j]=Math.max(DP[i-1][j],DP[i][j]);
                if(j-nowCost>=0) DP[i][j]=Math.max(DP[i-1][j],DP[i-1][j-nowCost]+app[i][0]);
            }
        }
        for(int i = 1 ; i <=total; i++) {
            if(DP[N-1][i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
