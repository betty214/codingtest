package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_15684 {
    static boolean[][]lad;
    static int N,M,H;
    static int answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/15684.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        lad= new boolean[H+1][N+1];
        answer=Integer.MAX_VALUE;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lad[x][y]=true;
        }
        DFS(0,1);
        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }static void DFS(int depth, int level){
        if(depth>3) {
            return;
        }
        if(check()) {
            answer=Math.min(answer,depth);
            return;
        }
        for(int i=level;i<=H;i++){
            for(int j=1;j<=N;j++){
                if(!lad[i][j]&&canGo(i,j)){
                    lad[i][j]=true;
                    DFS(depth+1,i);
                    lad[i][j]=false;
                }
            }
        }
    }
    static boolean check(){
        boolean flag=true;
        for(int i=1;i<=N;i++){
            int x=i;
            int y=1;

            while(y<=H && x<=N && x>0){
                if(lad[y][x]) x++;
                else if(lad[y][x-1]) x--;
                y++;
            }
            if(x!=i) flag=false;
        }
        return flag;
    }static boolean canGo(int x, int y){
        boolean flag=true;
        if(y>1){
            if(lad[x][y-1]) flag=false;
        }
        if(y<N){
            if(lad[x][y+1]) flag=false;
        }
        return flag;
    }
}
