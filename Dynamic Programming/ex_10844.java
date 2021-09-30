package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_10844 {
    static long [][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP=new long[N][10];
        for(int i=0;i<=9;i++){
            DP[0][i]=1L;
        }
        long answer=0;
        for(int i=1;i<10;i++){
            answer+=DFS(N-1,i);
        }
        System.out.println(answer%1000000000);
    }static long DFS(int index,int num){
        if(index==0){
            return DP[index][num];
        }
        if(DP[index][num]==0){
            if(num==0){
                DP[index][num]=DFS(index-1,1);
            }else if(num==9){
                DP[index][num]=DFS(index-1,8);
            }else{
                DP[index][num]=DFS(index-1,num-1)+DFS(index-1,num+1);
            }
        }return DP[index][num]%1000000000;
    }
}
