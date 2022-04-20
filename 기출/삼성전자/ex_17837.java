package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_17837 {
    static int[][]chess;
    static piece[]p;
    static ArrayList<Integer>[][]up;
    static int N,K;
    static boolean flag;
    static class piece{
        int x;
        int y;
        int dir;
        piece(int x, int y, int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17837.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chess=new int[N+1][N+1];
        up=new ArrayList[N+1][N+1];
        p=new piece[K];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                chess[i][j] = Integer.parseInt(st.nextToken());
                up[i][j]=new ArrayList<>();
            }
        }
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            p[i]=new piece(x,y,dir);
            up[y][x].add(i);
        }
        int count=0;
        flag=true;
        while(flag){
            for(int i=0;i<K;i++){
                determine(p[i],i);
            }
            if(count>1000) break;
            count++;
        }
        if(count>1000) System.out.println(-1);
        else System.out.println(count);
    }static void determine(piece now,int index){
        int cx,cy;
        switch(now.dir){
            //오른쪽
            case 1:
                cx=now.x+1;
                cy=now.y;
                if(check(cx,cy)){
                    move(now.x,now.y,cx,cy,index);
                }else{
                    if(check(cx-2,cy)){
                        move(now.x,now.y,cx-2,cy,index);
                    }p[index].dir=2;
                }
                break;
            //왼쪽
            case 2:
                cx=now.x-1;
                cy=now.y;
                if(check(cx,cy)){
                    move(now.x,now.y,cx,cy,index);
                }else{
                    if(check(cx+2,cy)){
                        move(now.x,now.y,cx+2,cy,index);
                    }p[index].dir=1;
                }
                break;
            //위쪽
            case 3:
                cx=now.x;
                cy=now.y-1;
                if(check(cx,cy)){
                    move(now.x,now.y,cx,cy,index);
                }else{
                    if(check(cx,cy+2)){
                        move(now.x,now.y,cx,cy+2,index);
                    }p[index].dir=4;
                }
                break;
            //아래쪽
            case 4:
                cx=now.x;
                cy=now.y+1;
                if(check(cx,cy)){
                    move(now.x,now.y,cx,cy,index);
                }else{
                    if(check(cx,cy-2)){
                        move(now.x,now.y,cx,cy-2,index);
                    }p[index].dir=3;
                }
                break;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(up[i][j].size()>=4) {
                    flag=false;
                }
            }
        }
    }static void move(int sx,int sy, int ex,int ey,int idx){
        int len=up[sy][sx].size();
        int index=up[sy][sx].indexOf(idx);
        int[]temp=new int[len-index];
        int count=0;
        if(ex==sx && ey==sy) return;
        if(chess[ey][ex]==1){
            for(int i=len-1;i>=index;i--){
                temp[count]=up[sy][sx].get(i);
                count++;
            }
        }else{
            for(int i=index;i<len;i++){
                temp[count]=up[sy][sx].get(i);
                count++;
            }
        }
        for(int i=0;i<temp.length;i++){
            up[ey][ex].add(temp[i]);
            p[temp[i]].x=ex;
            p[temp[i]].y=ey;
        }
        for(int i=index;i<len;i++){
            up[sy][sx].remove(index);
        }
    }static boolean check(int x,int y){
        if(x>N || y>N || x<=0 || y<=0) return false;
        else if(chess[y][x]==2) return false;
        return true;
    }
}