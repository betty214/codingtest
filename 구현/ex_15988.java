package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_15988 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long []DP=new long[N+1];
            if(N==1){
                System.out.println(1);
            }else if(N==2){
                System.out.println(2);
            }else if(N==3){
                System.out.println(4);
            }else{
                DP[1]=1;DP[2]=2;DP[3]=4;
                for(int j=4;j<=N;j++){
                    DP[j]=(DP[j-3]+DP[j-2]+DP[j-1])%1000000009;
                }
                System.out.println(DP[N]);
            }
        }
    }
}
