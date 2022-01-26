package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1932 {
    static int[][]DP,tri;
    static int n,answer;
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day8/1932.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tri=new int[n][n];
        DP=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                tri[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        answer=0;
        dynamic();
        System.out.println(answer);
    }static void dynamic(){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=tri[i][0];
            DP[i][0]=sum;
            answer=Math.max(DP[i][0],answer);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<i+1;j++){
                DP[i][j]=Math.max(DP[i-1][j],DP[i-1][j-1])+tri[i][j];
                answer=Math.max(DP[i][j],answer);
            }
        }
    }
}
