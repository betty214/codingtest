package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_3190 {
    static boolean flag;
    static int N,K,L,pos;
    static int[][]board;
    static char dir='R';
    static Deque<Node> q;
    static int[] dx = { 0, 1, 0,-1};
    static int[] dy = {1, 0, -1,0};
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
        System.setIn(new FileInputStream("code/src/input/3190.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board=new int[N][N];
        board[0][0]=2;
        flag=true;
        int index=1; pos=0;
        q=new ArrayDeque<>();
        q.addFirst(new Node(0,0));
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1]=1;
        }

        L = Integer.parseInt(br.readLine());
        char[]turn=new char[10000];
        Arrays.fill(turn,'N');

        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turn[X]=C;
        }

        while(flag){
            move();
            if(turn[index]=='D') pos++;
            else if(turn[index]=='L') pos--;
            if(pos==-1) pos=3;
            else if(pos==4) pos=0;
            index++;
        }
        System.out.println(index-1);
    }static void move(){
        Node head=q.peekLast();
        Node tail=q.peekFirst();

        if(flag){
            int nowX=head.x+dx[pos];
            int nowY=head.y+dy[pos];
            if(check(nowX,nowY)){
                if(board[nowX][nowY]==1){
                    board[nowX][nowY]=2;
                    q.addLast(new Node(nowX,nowY));
                }else{
                    board[tail.x][tail.y]=0;
                    q.poll();
                    board[nowX][nowY]=2;
                    q.addLast(new Node(nowX,nowY));
                }
            }
        }
    }static boolean check(int x, int y){
        if(x<0||y<0||x>=N||y>=N|| board[x][y]==2) {
            flag=false;
            return false;
        }
        else return true;
    }static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
