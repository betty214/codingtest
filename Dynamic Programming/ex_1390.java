package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_1390 {
    static int [][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP=new int[N][3];
        for(int i=0;i<3;i++){
            DP[0][i]=1;
        }
        int sum=DFS(N-1,0)+DFS(N-1,1)+DFS(N-1,2);
        System.out.println(sum%9901);
    }static int DFS(int index,int p){
        if(index==0){
            return DP[index][p];
        }
        if(DP[index][p]==0){
            if(p==0){
                DP[index][p]=DFS(index-1,1)+DFS(index-1,2);
            }else if(p==1){
                DP[index][p]=DFS(index-1,0)+DFS(index-1,2);
            }else{
                DP[index][p]=DFS(index-1,0)+DFS(index-1,1)+DFS(index-1,2);
            }DP[index][p]%=9901;
        }
        return DP[index][p];
    }
}
