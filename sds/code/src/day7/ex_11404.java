package day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11404 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day7/11404.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][]arr=new int[n+1][n+1];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b]==0||arr[a][b]>c) arr[a][b]=c;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++) {
                    if (j != k && arr[j][i] != 0 && arr[i][k] != 0) {
                        if (arr[j][i] + arr[i][k] < arr[j][k] || arr[j][k] == 0) arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }
        for(int i = 1 ; i <= n ;i++) {
            for(int j = 1 ; j <= n ;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
