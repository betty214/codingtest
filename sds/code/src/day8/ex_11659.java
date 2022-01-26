package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11659 {
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day8/11659.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int []sum=new int[n+1];
        int s=0;
        for(int i=1;i<=n;i++){
            s+=Integer.parseInt(st.nextToken());
            sum[i]=s;
        }
        for(int j=0;j<m;j++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(sum[y]-sum[x-1]);
        }
    }
}
