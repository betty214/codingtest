package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_1926 {
    static int []dx={1,-1,0,0};
    static int []dy={0,0,1,-1};
    static int [][] paper;
    static boolean [][] visited;
    static int N,M,width,max,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        max=0;
        count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                width=0;
                DFS(i,j);
                if(width>max){
                    max=width;
                }if(width>0){
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    static void DFS(int x, int y){
        if(!visited[x][y]&&paper[x][y]==1){
            visited[x][y]=true;
            width++;
            for(int i=0;i<4;i++){
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(check(cx,cy)){
                    DFS(cx,cy);
                }
            }
        }
    }static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=M){
            return false;
        }else{
            if(paper[x][y]==1){
                return true;
            }else {
                return false;
            }
        }
    }
}
