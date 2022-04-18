package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_17142 {
    static int N,M,answer,blank;
    static int[][]lab,temp;
    static ArrayList<Node> virus;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    private static class Node{
        int x;
        int y;
        Node(int x, int y){
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
        System.setIn(new FileInputStream("input/17142.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab=new int[N][N];
        virus=new ArrayList<>();
        answer=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j]==2) virus.add(new Node(i,j));
                if(lab[i][j]==0) blank++;
            }
        }
        if(blank==0) System.out.println(0);
        else{
            comb(0,0,new boolean[virus.size()]);
            if(answer==Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(answer-1);
        }

    }static void comb(int start, int depth, boolean[]visited){
        if(depth==M) {
            time(visited);
            return;
        }

        for(int i=start;i<virus.size();i++){
            visited[i]=true;
            comb(i + 1,depth+1,visited);
            visited[i]=false;
        }
    }
    static void time(boolean[]visited){
        Queue<Node>q=new LinkedList<>();
        temp=new int[N][N];
        copy();
        for(int i=0;i<virus.size();i++){
            if(visited[i]){
                q.add(virus.get(i));
            }else{
                temp[virus.get(i).x][virus.get(i).y]=-1;
            }
        }
        int count=0;

        Queue<Node>pq=new LinkedList<>();
        pq.add(q.poll());
        while(!pq.isEmpty()){
            while(!pq.isEmpty()){
                q.add(pq.poll());
            }
            count++;
            while(!q.isEmpty()){
                Node now = q.poll();
                for(int i=0;i<4;i++){
                    int cx=dx[i]+now.x;
                    int cy=dy[i]+now.y;
                    if(check(cx,cy)){
                        if(temp[cx][cy]==0 ||temp[cx][cy]==-1 ){
                            temp[cx][cy]=2;
                            pq.add(new Node(cx,cy));
                        }
                    }
                }
            }if(check2()) break;
        }
        if(check2()){
            answer=Math.min(count+1, answer);
        }

    }static void copy(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[i][j]=lab[i][j];
            }
        }
    }static boolean check(int x, int y){
        if(x<0 || y<0 || x>=N || y>=N) return false;
        return true;
    }static boolean check2(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(temp[i][j]==0) return false;
            }
        }return true;
    }
}
