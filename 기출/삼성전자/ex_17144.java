package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17144 {
    static int R,C,T,answer;
    static int[][]room;
    static int[]clean;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17144.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        answer=0;
        clean=new int[2];
        room=new int[R][C];
        int index=0;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                room[i][j]=Integer.parseInt(st.nextToken());
                if(room[i][j]==-1) clean[index++]=i;
            }
        }
        for(int i=0;i<T;i++){
            spread();
            turn();
        }
        count();
        System.out.println(answer+2);
    }static void spread(){
        int[][]temp=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(room[i][j]>0){
                    int add=room[i][j]/5;
                    int c=0;
                    for(int k=0;k<4;k++){
                        int cx=dx[k]+i;
                        int cy=dy[k]+j;
                        if(check(cx,cy)){
                            if(cx==clean[0] && cy==0) continue;
                            if(cx==clean[1] && cy==0) continue;
                            temp[cx][cy]+=add;
                            c++;
                        }
                    }
                    temp[i][j]+=room[i][j]-add*c;
                }
            }
        }
        copy(temp);
    }static void turn(){
        int[][]temp=new int[R][C];
        temp[0][C-1]=room[1][C-1];
        temp[R-1][C-1]=room[R-2][C-1];
        temp[1][0]=room[0][0];
        temp[R-2][0]=room[R-1][0];

        for(int j=1;j<C-1;j++){ //우
            temp[clean[0]][j+1]=room[clean[0]][j];
            temp[clean[1]][j+1]=room[clean[1]][j];
        }
        for(int i=0;i<clean[0];i++){ //상
            temp[i][C-1]=room[i+1][C-1];
        }
        for(int i=clean[1]+1;i<R;i++){
            temp[i][C-1]=room[i-1][C-1];
        }
        for(int j=0;j<C-1;j++){ //좌
            temp[0][j]=room[0][j+1];
            temp[R-1][j]=room[R-1][j+1];
        }
        for(int i=1;i<clean[0];i++){ //하
            temp[i][0]=room[i-1][0];
        }
        for(int i=clean[1]+1;i<R-1;i++) {
            temp[i][0] = room[i + 1][0];
        }
        copy2(temp);
    }static void count(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) {
                answer+=room[i][j];
            }
        }
    }static boolean check(int x, int y){
        if(x<0 || y<0 || x>=R || y>=C) return false;
        return true;
    }static void copy(int [][]temp){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                room[i][j]=temp[i][j];
            }
        }
        room[clean[0]][0]=-1;
        room[clean[1]][0]=-1;
    }static void copy2(int [][]temp){
        for(int i=0;i<R;i++){
            if(i==0 || i==clean[0] ||i==clean[1] || i==R-1) {
                for(int j=0;j<C;j++){
                    room[i][j]=temp[i][j];
                }
            }else{
                room[i][0]=temp[i][0];
                room[i][C-1]=temp[i][C-1];
            }
        }
        room[clean[0]][0]=-1;
        room[clean[1]][0]=-1;
    }
}