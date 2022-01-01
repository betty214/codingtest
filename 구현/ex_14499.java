package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14499 {
    private static class Dice {
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;
        int x;
        int y;

        public Dice(int top, int bottom, int left, int right, int front,int back,int x,int y) {
            this.top=top;
            this.bottom=bottom;
            this.left=left;
            this.right=right;
            this.front=front;
            this.back=back;
            this.x=x;
            this.y=y;
        }
    }
    static int N,M,K;
    static int[][]board;
    static Dice dice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        dice = new Dice(0,0,0,0,0,0,x,y);
        K = Integer.parseInt(st.nextToken());
        board=new int[N][M];
        int []order=new int[K];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            order[i]=Integer.parseInt(st.nextToken());
            boolean flag=true;
            switch(order[i]){
                case 1:
                    if(check(dice.x,dice.y+1)){
                        move_East();
                    }else{
                        flag=false;
                    }
                    break;
                case 2:
                    if(check(dice.x,dice.y-1)){
                        move_West();
                    }else{
                        flag=false;
                    }
                    break;
                case 3:
                    if(check(dice.x-1,dice.y)){
                        move_North();
                    }else{
                        flag=false;
                    }
                    break;
                case 4:
                    if(check(dice.x+1,dice.y)){
                        move_South();
                    }else{
                        flag=false;
                    }
                    break;
            }
            if(flag){
                if(board[dice.x][dice.y]==0){
                    board[dice.x][dice.y]=dice.bottom;
                }else{
                    dice.bottom=board[dice.x][dice.y];
                    board[dice.x][dice.y]=0;
                }
                System.out.println(dice.top);
            }
        }
        //System.out.println(dice.top+" "+dice.bottom+" "+dice.left+" "+dice.right+" "+dice.front+" "+dice.back);
    }
    static void move_East(){
        int temp=dice.right;
        dice.right=dice.top;
        int temp2=dice.bottom;
        dice.bottom=temp;
        temp=dice.left;
        dice.left=temp2;
        dice.top=temp;
        dice.y++;
    }
    static void move_West(){
        int temp=dice.right;
        dice.right=dice.bottom;
        int temp2=dice.top;
        dice.top=temp;
        temp=dice.left;
        dice.left=temp2;
        dice.bottom=temp;
        dice.y--;
    }
    static void move_North(){
        int temp=dice.front;
        dice.front=dice.top;
        int temp2=dice.bottom;
        dice.bottom=temp;
        temp=dice.back;
        dice.back=temp2;
        dice.top=temp;
        dice.x--;
    }
    static void move_South(){
        int temp=dice.back;
        dice.back=dice.top;
        int temp2=dice.bottom;
        dice.bottom=temp;
        temp=dice.front;
        dice.front=temp2;
        dice.top=temp;
        dice.x++;
    }
    static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=M){
            return false;
        }else{
            return true;
        }
    }
}
