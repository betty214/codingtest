package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_15683 {
    static int N,M,answer,count;
    static int[][]office;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static ArrayList<Node>camera;
    static private class Node{
        int x;
        int y;
        int cctv;
        public Node(int x, int y, int cctv){
            this.x=x;
            this.y=y;
            this.cctv=cctv;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/15683.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        office=new int[N][M];
        camera=new ArrayList<>();
        answer=Integer.MAX_VALUE;
        count=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int input=Integer.parseInt(st.nextToken());
                if(0<input && input<6) camera.add(new Node(i,j,input));
                office[i][j]=input;
            }
        }

        DFS(0,office);
        if(answer==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }static void DFS(int index,int[][]board){
        if(index>camera.size()) return;
        else if(index== camera.size()) {
            print(board);
            return;
        }
        Node now = camera.get(index);
        switch(now.cctv){
            case 1:
                for(int i=0;i<4;i++){
                    int[][]temp=new int[N][M];
                    copy(board,temp);
                    int cx=now.x+dx[i];
                    int cy=now.y+dy[i];
                    while(check(cx,cy)){
                        if(temp[cx][cy]==6) break;
                        temp[cx][cy]=7;
                        cx+=dx[i];
                        cy+=dy[i];
                    }
                    DFS(index+1,temp);
                }
                break;
            case 2:
                for(int i=0;i<4;i+=2){
                    int[][]temp=new int[N][M];
                    copy(board,temp);
                    int c1x=now.x+dx[i];
                    int c1y=now.y+dy[i];
                    int c2x=now.x+dx[i+1];
                    int c2y=now.y+dy[i+1];
                    while(check(c1x,c1y) || check(c2x,c2y)){
                        int now1=0;
                        int now2=0;
                        if(!check(c1x,c1y)) now1=6;
                        else now1=temp[c1x][c1y];
                        if(!check(c2x,c2y)) now2=6;
                        else now2=temp[c2x][c2y];
                        if(now1==6 && now2==6) break;
                        if(now1!=6){
                            temp[c1x][c1y]=7;
                            c1x+=dx[i];
                            c1y+=dy[i];
                        }
                        if(now2!=6){
                            temp[c2x][c2y]=7;
                            c2x+=dx[i+1];
                            c2y+=dy[i+1];
                        }
                    }
                    DFS(index+1,temp);
                }
                break;
            case 3: //무한루프
                for(int i=0;i<2;i++){
                    for(int j=2;j<4;j++){
                        int[][]temp=new int[N][M];
                        copy(board,temp);
                        int c1x=now.x+dx[i];
                        int c1y=now.y+dy[i];
                        int c2x=now.x+dx[j];
                        int c2y=now.y+dy[j];
                        while(check(c1x,c1y) || check(c2x,c2y)){
                            int now1=0;
                            int now2=0;
                            if(!check(c1x,c1y)) now1=6;
                            else now1=temp[c1x][c1y];
                            if(!check(c2x,c2y)) now2=6;
                            else now2=temp[c2x][c2y];
                            if(now1!=6){
                                temp[c1x][c1y]=7;
                                c1x+=dx[i];
                                c1y+=dy[i];
                            }
                            if(now2!=6){
                                temp[c2x][c2y]=7;
                                c2x+=dx[j];
                                c2y+=dy[j];
                            }
                            if(now1==6 && now2==6) break;
                        }
                        DFS(index+1,temp);
                    }
                }
                break;
            case 4:
                for(int i=0;i<4;i++){
                    int[][]temp=new int[N][M];
                    copy(board,temp);
                    for(int j=0;j<4;j++){
                        if(i==j) continue;
                        int cx=now.x+dx[j];
                        int cy=now.y+dy[j];
                        while(check(cx,cy)){
                            if(temp[cx][cy]==6) break;
                            temp[cx][cy]=7;
                            cx+=dx[j];
                            cy+=dy[j];
                        }
                    }DFS(index+1,temp);
                }
                break;
            case 5:
                int[][]temp=new int[N][M];
                copy(board,temp);
                for(int i=0;i<4;i++){
                    int cx=now.x+dx[i];
                    int cy=now.y+dy[i];

                    while(check(cx,cy)){
                        if(temp[cx][cy]==6) break;
                        temp[cx][cy]=7;
                        cx+=dx[i];
                        cy+=dy[i];
                    }
                }
                DFS(index+1,temp);
                break;
        }
    }static void copy(int [][]origin, int[][]temp){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp[i][j]=origin[i][j];
            }
        }
    }static boolean check(int x, int y){
        if(x<0||x>=N||y<0||y>=M)return false;
        return true;
    }static void print(int[][]board){
        int temp=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==0) temp++;
            }
        }

        answer=Math.min(temp,answer);
        if(temp==0) {
            System.out.println(answer);
            System.exit(0);
        }
    }
}
