package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_13460 {
    static int N,M,Ox,Oy,count;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static char[][]board;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/13460.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board=new char[N][M];
        int Bx=0; int By=0; int Rx=0; int Ry=0; count=11;
        flag=false;
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=input.charAt(j);
                if(board[i][j]=='R') {
                    Rx=i;
                    Ry=j;
                }else if(board[i][j]=='B') {
                    Bx=i;
                    By=j;
                }else if(board[i][j]=='O') {
                    Ox=i;
                    Oy=j;
                }
            }
        }
        DFS(Bx,By,Rx,Ry,0);
        System.out.println(count+1);
    }static void DFS(int Bx, int By, int Rx, int Ry, int depth){
        if(!flag && depth<10){
            for(int i=0;i<4;i++){
                int cBx=Bx+dx[i];
                int cBy=By+dy[i];
                int cRx=Rx+dx[i];
                int cRy=Ry+dy[i];
                boolean bFlag=false;
                boolean rFlag=false;
                while(check(cBx,cBy)&& board[cBx][cBy]!='#'){
                    if(isHoll(cBx,cBy)){
                        bFlag=true;
                        break;
                    }
                    cBx+=dx[i];
                    cBy+=dy[i];
                }
                while(check(cRx,cRy)&& board[cRx][cRy]!='#'){
                    if(isHoll(cRx,cRy)){
                        rFlag=true;
                        break;
                    }
                    cRx+=dx[i];
                    cRy+=dy[i];
                }
                if(bFlag&&!rFlag) continue;
                if(rFlag && !bFlag) {
                    flag=true;
                    count=Math.min(count, depth);
                    break;
                }
                if(!flag && check(cBx,cBy) && check(cRx,cRy)) DFS(cBx, cBy, cRx, cRy, depth+1);
            }
        }
    }static boolean check(int x, int y){
        if(x>=N||y>=M||x<0||y<0) return false;
        return true;
    }static boolean isHoll(int x, int y){
        if(x==Ox && y==Oy) return true;
        return false;
    }
}
