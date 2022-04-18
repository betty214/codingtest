package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17779 {
    static int N,answer,total;
    static int [][]A,B;
    static boolean [][] border;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17779.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A=new int[N][N];
        total=0;
        answer=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
                total+=A[i][j];
            }
        }
        //x,y,d1,d2 조합
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=1;k<N;k++){
                    for(int l=1;l<N;l++){
                        if(check(i,j,k,l)) {
                            makeBorder(i,j,k,l);
                            getCount(i,j,k,l);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static boolean check(int x, int y, int d1, int d2){
        if(x+d1+d2>=N) return false;
        if(y-d1<0) return false;
        if(y+d2>=N) return false;
        return true;
    }
    //각 구역 인구수 구하기
    static void getCount(int x, int y, int d1, int d2){
        int[]count=new int[5];
        int minValue=Integer.MAX_VALUE;
        int maxValue=Integer.MIN_VALUE;
        B=new int[N][N];
        //1번 선거구
        for(int i=y-1;i>=0;i--){
            for(int j=0;j<=x+d1;j++){
                if(border[i][j]) break;
                count[0]+=A[i][j];
                B[i][j]=1;
            }
        }
        //2번 선거구
        for(int i=y-d1+d2;i>=0;i--){
            for(int j=N-1;j>x+d1;j--){
                if(border[i][j]) break;
                count[1]+=A[i][j];
                B[i][j]=2;
            }
        }
        //3번 선거구
        for(int i=y;i<N;i++){
            for(int j=0;j<x+d2;j++){
                if(border[i][j]) break;
                count[2]+=A[i][j];
                B[i][j]=3;
            }
        }
        //4번 선거구
        for(int i=y-d1+d2+1;i<N;i++){
            for(int j=N-1;j>=x+d2;j--){
                if(border[i][j]) break;
                count[3]+=A[i][j];
                B[i][j]=4;
            }
        }
        count[4]=total-(count[0]+count[1]+count[2]+count[3]);
        for(int i=0;i<5;i++){
            maxValue=Math.max(maxValue,count[i]);
            minValue=Math.min(minValue,count[i]);
        }
        answer=Math.min(maxValue-minValue,answer);
    }
    static void makeBorder(int x, int y, int d1, int d2){
        border=new boolean[N][N];

        //1번
        int nowY=y;
        for(int i=x;i<=x+d1;i++){
            border[nowY][i]=true;
            nowY--;
        }
        //2번
        nowY=y+1;
        for(int i=x+1;i<=x+d2;i++){
            border[nowY][i]=true;
            nowY++;
        }
        //3번
        nowY=y-d1+1;
        for(int i=x+d1+1;i<=x+d2+d1;i++){
            border[nowY][i]=true;
            nowY++;
        }
        //4번
        nowY=y+d2-1;
        for(int i=x+d2+1;i<x+d2+d1;i++){
            border[nowY][i]=true;
            nowY--;
        }
    }static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(border[i][j]) System.out.print("⬛ ");
                else System.out.print("⬜ ");
            }
            System.out.println();
        }
    }
    static void printB(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }
    }
}
