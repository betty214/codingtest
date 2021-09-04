package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex_3190 {
    static int N,L,time;
    static Deque<Integer> x_q = new LinkedList<>();
    static Deque<Integer> y_q = new LinkedList<>();
    static int[] dx = { 0, 1, 0,-1};
    static int[] dy = {1, 0, -1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int [][]board=new int[N][N];
        int K=Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1]=1;
        }
        L=Integer.parseInt(br.readLine());
        int []turn=new int[L];
        char []pos=new char[L];
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char where = st.nextToken().charAt(0);
            turn[i]=t;
            pos[i]=where;
        }
        board[0][0]=2;
        x_q.add(0);
        y_q.add(0);

        time=0;
        int s_now_x=0;
        int s_now_y=0;
        int now_pos=0;
        int index=0;
        while(detect(s_now_x,s_now_y)){
            if(index<L){
                if(turn[index]==time){
                    if(pos[index]=='D'){
                        now_pos++;
                    }else{
                        now_pos--;
                    }
                    if(now_pos==-1){
                        now_pos=3;
                    }else if(now_pos==4){
                        now_pos=0;
                    }
                    index++;
                }
            }
            s_now_x+=dx[now_pos];
            s_now_y+=dy[now_pos];
            x_q.addFirst(s_now_x);
            y_q.addFirst(s_now_y);
            if(detect(s_now_x,s_now_y)){
                if (board[s_now_x][s_now_y] == 1) {
                    board[s_now_x][s_now_y] = 2;
                } else if (board[s_now_x][s_now_y] == 0) {
                    board[s_now_x][s_now_y] = 2;
                    board[x_q.peekLast()][y_q.peekLast()] = 0;
                    x_q.pollLast();
                    y_q.pollLast();
                } else {
                    time++;
                    break;
                }
            }time++;
        }
        System.out.println(time);
    }
    static boolean detect(int s_x,int s_y){
        if(s_x>=0 && s_y>=0 && s_x<N && s_y<N){
            return true;
        }else{
            return false;
        }
    }
}
