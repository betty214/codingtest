package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_11057 {
    static int [][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP=new int[N][10];
        for(int i=0;i<10;i++){
            DP[0][i]=1;
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<10;j++){
                DP[i][j]=make_DP(i,j)%10007;
            }
        }
        int answer=0;
        for(int i=0;i<10;i++){
            answer+=DP[N-1][i];
        }
        System.out.println(answer%10007);
    }static int make_DP(int x, int y){
        int sum=0;
        for(int i=y;i<10;i++){
            sum+=DP[x-1][i];
        }return sum;
    }
}
