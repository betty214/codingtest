package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11660 {
    static int [][]arr,DP;
    static int n;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day8/11660.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr=new int[n+1][n+1];
        DP=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        sum();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            System.out.println(DP[endX][endY]-DP[startX-1][endY]-DP[endX][startY-1]+DP[startX-1][startY-1]);
        }
    }static void sum(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                DP[i][j]=DP[i-1][j]+DP[i][j-1]+arr[i][j]-DP[i-1][j-1];
            }
        }
    }
}
