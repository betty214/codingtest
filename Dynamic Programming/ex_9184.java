package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_9184 {
    static int [][][]DP;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while(end(a,b,c)){
            if(a<=0||b<=0||c<=0){
                System.out.println("w("+a+", "+b+", "+c+") = 1");
            }else if(a>20||b>20||c>20){
                System.out.println("w("+a+", "+b+", "+c+") = 1048576");
            }else{
                DP=new int[a+1][b+1][c+1];
                System.out.println("w("+a+", "+b+", "+c+") = "+DFS(a,b,c));
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }static boolean end(int a,int b,int c){
        if(a==-1&&b==-1&&c==-1){
            return false;
        }else{
            return true;
        }
    }static int DFS(int a,int b,int c){
        if(a<=0||b<=0||c<=0){
            return 1;
        }
        if(DP[a][b][c]==0){
            if(a<b&&b<c){
                DP[a][b][c]=DFS(a,b,c-1)+DFS(a,b-1,c-1)-DFS(a,b-1,c);
            }else{
                DP[a][b][c]=DFS(a-1,b,c)+DFS(a-1,b-1,c)+DFS(a-1,b,c-1)-DFS(a-1,b-1,c-1);
            }
        }return DP[a][b][c];
    }
}
