package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_3055 {
    static char [][] land;
    static int [][] time;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static Node dest;
    static int R,C;
    private static class Node{
        int x;
        int y;
        boolean water;
        public Node(int x,int y,boolean water){
            this.x=x;
            this.y=y;
            this.water=water;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/3055.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        land=new char[R][C];
        time=new int[R][C];
        Queue<Node> q=new LinkedList<>();
        int[]src=new int[2];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            String in=st.nextToken();
            for(int j=0;j<C;j++){
                char input=in.charAt(j);
                if(input=='D') dest=new Node(i,j,false);
                else if(input=='S'){
                    time[i][j]=0;
                    src[0]=i;
                    src[1]=j;
                }
                else if(input=='*')q.add(new Node(i,j,true));
                land[i][j]=input;
            }
        }q.add(new Node(src[0],src[1],false));
        boolean flag=false;
        while(!q.isEmpty()){
            Node now = q.poll(); //1. 큐에서 꺼내옴
            if(now.water){
                for(int i=0;i<4;i++){//3.연결된 곳 순회
                    int cx=now.x+dx[i];
                    int cy=now.y+dy[i];
                    if(check_water(cx,cy)){//4.갈 수 있는가
                        land[cx][cy]='*';//5.체크인
                        Node next=new Node(cx,cy,true);
                        if(!q.contains(next)) q.add(next);//6.큐에 넣음
                    }
                }
            }else{
                for(int i=0;i<4;i++){//3.연결된 곳 순회
                    int cx=now.x+dx[i];
                    int cy=now.y+dy[i];
                    if(check_hedge(cx,cy)){//4.갈 수 있는가
                        time[cx][cy]=time[now.x][now.y]+1;//5.체크인
                        if(cx==dest.x && cy==dest.y){//2. 목적지인가
                            System.out.println(time[cx][cy]);
                            flag=true;
                            q.clear();
                            break;
                        }
                        Node next=new Node(cx,cy,false);
                        if(!q.contains(next)) q.add(next);//6.큐에 넣음
                    }
                }
            }
        }
        if(!flag) System.out.println("KAKTUS");
    }static boolean check_hedge(int x,int y){
        if(x<R && x>=0 && y>=0 && y<C && time[x][y]==0) {
            if(land[x][y]=='D' || land[x][y]=='.') return true;
        }
        return false;
    }static boolean check_water(int x,int y){
        if(x<R && x>=0 && y>=0 && y<C && land[x][y]=='.' && time[x][y]==0) return true;
        return false;
    }
}
