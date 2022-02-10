package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_3055 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int R,C;
    static char[][]forest;
    static  int [][]time;
    static private class Node{
        int x;
        int y;
        boolean water;
        public Node(int x, int y,boolean water){
            this.x=x;
            this.y=y;
            this.water=water;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/3055.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R =Integer.parseInt(st.nextToken());
        C =Integer.parseInt(st.nextToken());
        forest=new char[R][C];
        time=new int[R][C];
        Node D = null;
        Node S=null;
        Queue<Node>q=new LinkedList<>();
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            String now=st.nextToken();
            for(int j=0;j<C;j++){
                forest[i][j]=now.charAt(j);
                if(forest[i][j]=='D') D=new Node(i,j,false);
                if(forest[i][j]=='S') {
                    time[i][j]=0;
                    S=new Node(i,j,false);
                }
                if(forest[i][j]=='*') q.add(new Node(i,j,true));
            }
        }

        q.add(S);
        boolean flag=false;
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=0;i<4;i++){
                int cx=n.x+dx[i];
                int cy=n.y+dy[i];
                if(check_hedge(cx,cy)){
                    if(n.water && forest[cx][cy]=='.'){
                        forest[cx][cy]='*';
                        Node next=new Node(cx,cy,true);
                        if(!q.contains(next)) q.add(next);
                    } else {
                        time[cx][cy]=time[n.x][n.y]+1;
                        if(D.x==cx && D.y==cy){
                            System.out.println(time[cx][cy]);
                            flag=true;
                            q.clear();
                            break;
                        }else{
                            Node next=new Node(cx,cy,false);
                            if(!q.contains(next)) q.add(next);
                        }
                    }
                }
            }
        }
        if(!flag) System.out.println("KAKTUS");
    }static boolean check_hedge(int x,int y){
        if(x<R && x>=0 && y>=0 && y<C && time[x][y]==0) {
            if(forest[x][y]=='D' || forest[x][y]=='.') return true;
        }
        return false;
    }static boolean check_water(int x,int y){
        if(x<R && x>=0 && y>=0 && y<C && forest[x][y]=='.' && time[x][y]==0) return true;
        return false;
    }
}
