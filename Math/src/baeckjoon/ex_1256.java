package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1256 {
    static int N,M;
    static long K;
    static double[][] DP;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Long.parseLong(st.nextToken());
        DP=new double[N+1][M+1];
        getResult(N,M,K);
        if(check(N,M)<K)
            System.out.println(-1);
        else
            System.out.println(sb.toString());

    }static double check(int a,int z){
        if(a==0 || z==0)
            return 1;
        if(DP[a][z]!=0)
            return DP[a][z];
        return DP[a][z]=Double.min(check(a-1,z)+check(a,z-1),Double.MAX_VALUE);
    }static void getResult(int a,int z,double k){
        if(a==0){
            for(int i=0;i<z;i++)
                sb.append("z");
            return;
        }
        if(z==0){
            for(int i=0;i<a;i++)
                sb.append("a");
            return;
        }
        double check = check(a - 1, z);
        if(k>check){
            sb.append("z");
            getResult(a,z-1,k-check);
        }
        else{
            sb.append("a");
            getResult(a-1,z,k);
        }
    }
}
