package day9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11049 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day9/11049.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []r=new int[n+1];
        int []c=new int[n+1];
        int D [][] = new int [n+1+1][n+1+1];
        final int INF = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i]=Integer.parseInt(st.nextToken());
            c[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=n-1;i>0;i--){
            for(int j=i+1;j<=n;j++){
                D[i][j]=INF;
                for(int k=i;k<=j;k++){
                    D[i][j]=Math.min(D[i][j],D[i][k]+D[k+1][j]+r[i]*c[k]*c[j]);
                }
            }
        }
        System.out.println(D[1][n]);
    }
}
