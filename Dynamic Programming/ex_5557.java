package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []number =new int[N];
        long [][]DP=new long[N][21];
        for(int i=0;i<N;i++){
            number[i]=Integer.parseInt(st.nextToken());
        }
        DP[0][number[0]]=1;
        for(int i=1;i<N-1;i++){
            for(int j=0;j<21;j++){
                if(DP[i-1][j]==0)
                    continue;
                if(j+number[i]<=20){
                    DP[i][j+number[i]]+=DP[i-1][j];
                }if(j-number[i]>=0){
                    DP[i][j-number[i]]+=DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N-2][number[N-1]]);
    }
}
