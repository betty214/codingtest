package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14499 {
    static int N,M,x,y;
    static int[][]map;
    static int []dice=  {0, 0, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14499.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map=new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int order = Integer.parseInt(st.nextToken());
            if(move(order)) System.out.println(dice[0]);
        }
    }static boolean move(int order){
        int temp=dice[0];
        boolean flag=false;
        switch(order){
            case 1:
                if(flag=check(x,y+1)){
                    y++;
                    dice[0]=dice[2];
                    dice[2]=dice[1];
                    dice[1]=dice[3];
                    dice[3]=temp;
                }
                break;
            case 2:
                if(flag=check(x,y-1)){
                    y--;
                    dice[0]=dice[3];
                    dice[3]=dice[1];
                    dice[1]=dice[2];
                    dice[2]=temp;
                }
                break;
            case 3:
                if(flag=check(x-1,y)){
                    x--;
                    dice[0]=dice[4];
                    dice[4]=dice[1];
                    dice[1]=dice[5];
                    dice[5]=temp;
                }
                break;
            case 4:
                if(flag=check(x+1,y)){
                    x++;
                    dice[0]=dice[5];
                    dice[5]=dice[1];
                    dice[1]=dice[4];
                    dice[4]=temp;
                }
                break;
        }
        if(flag){
            if(map[x][y]==0) map[x][y]=dice[1];
            else{
                dice[1]=map[x][y];
                map[x][y]=0;
            }
        }return flag;
    }static void print(){
        for(int i=0;i<6;i++){
            System.out.print(dice[i]+" ");
        }
        System.out.println();
    }static boolean check(int x, int y){
        if(x>=N||y>=M||x<0||y<0) return false;
        return true;
    }
}
