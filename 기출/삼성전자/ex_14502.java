package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_14502 {
    static int N,M,answer;
    static int [][]board,temp;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static Queue<Node>q;
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board=new int[N][M];
        temp=new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                temp[i][j]=board[i][j];
            }
        }
        answer=0;
        comb(0);
        System.out.println(answer);
    }static void comb(int depth){
        if(depth==3) {
            spread();
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==0){
                    board[i][j]=1;
                    comb(depth+1);
                    board[i][j]=0;
                }
            }
        }
    }static void spread(){
        q=new LinkedList<>();
        init();
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int cx=now.x+dx[i];
                int cy=now.y+dy[i];
                if(check(cx,cy)&&temp[cx][cy]==0){
                    temp[cx][cy]=2;
                    if(!q.contains(new Node(cx,cy))) q.add(new Node(cx,cy));
                }
            }
        }
        count();
        init();
    }static boolean check(int x, int y){
        if(x>=N||x<0||y>=M||y<0) return false;
        return true;
    }static void count(){
        int ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j]==0) ans++;
            }
        }
        answer=Math.max(ans,answer);
    }static void init(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp[i][j]=board[i][j];
                if(temp[i][j]==2) q.add(new Node(i,j));
            }
        }
    }
}
