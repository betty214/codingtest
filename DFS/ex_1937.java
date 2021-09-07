package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1937 {
    static int[][] bamboo,DP;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static int count,answer,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bamboo=new int[N][N];
        DP=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                bamboo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                count=0;
                int n = DFS(i,j);
                if(n>answer) {
                    answer=n;
                }
                DP[i][j]=n;
            }
        }System.out.println(answer+1);
    }
    static int DFS(int x,int y){
        if(DP[x][y]!=0){
            return DP[x][y];
        }
        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(check(cx,cy,x,y)){
                if(bamboo[cx][cy]>bamboo[x][y]){
                    DP[x][y]= Math.max(DP[x][y], DFS(cx, cy) + 1);
                }
            }
        }return DP[x][y];
    }
    static boolean check(int cx,int cy,int x,int y){
        if(cx>=N||cy>=N||cx<0||cy<0){
            return false;
        }else{
            return true;
        }
    }
}
