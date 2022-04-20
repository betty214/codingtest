package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17822 {
    static int N,M,T,answer;
    static int [][] circle;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17822.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        circle=new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            turn(x,d,k);
            delete();
            print();
        }
        System.out.println(answer);
    }static void turn(int x,int d, int k){
        int[][]temp=new int[N][M];
        switch(d){
            //시계 방향
            case 0:
                for(int i=1;i<=N;i++){
                    if(i%x==0){
                        int index=0;
                        for(int j=M-k;j<M;j++){
                            temp[i-1][index]=circle[i-1][j];
                            index++;
                        }for(int j=0;j<M-k;j++){
                            temp[i-1][index]=circle[i-1][j];
                            index++;
                        }
                    }else{
                        for(int j=0;j<M;j++){
                            temp[i-1][j]=circle[i-1][j];
                        }
                    }
                }
                break;
            //반시계 방향
            case 1:
                for(int i=1;i<=N;i++){
                    if(i%x==0){
                        int index=0;
                        for(int j=k;j<M;j++){
                            temp[i-1][index]=circle[i-1][j];
                            index++;
                        }for(int j=0;j<k;j++){
                            temp[i-1][index]=circle[i-1][j];
                            index++;
                        }
                    }else{
                        for(int j=0;j<M;j++){
                            temp[i-1][j]=circle[i-1][j];
                        }
                    }
                }
                break;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                circle[i][j]=temp[i][j];
            }
        }
    }static void delete(){
        int[][]temp=new int[N][M];
        boolean flag=false;
        for(int i=0;i<N;i++){
            if(circle[i][0]!=0 && circle[i][0]==circle[i][M-1]){
                temp[i][0]=-1;
                temp[i][M-1]=-1;
                flag=true;
            }
            for(int j=0;j<M-1;j++){
                if(circle[i][j]!=0 && circle[i][j]==circle[i][j+1]){
                    temp[i][j]=-1;
                    temp[i][j+1]=-1;
                    flag=true;
                }
            }
        }
        int sum=0;
        int count=0;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M;j++){
                sum+=circle[i][j];
                if(circle[i][j]!=0) count++;
                if(circle[i][j]!=0 &&circle[i][j]==circle[i+1][j]){
                    temp[i][j]=-1;
                    temp[i+1][j]=-1;
                    flag=true;
                }
            }
        }

        if(flag){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(temp[i][j]==-1) circle[i][j]=0;
                }
            }
        }else{
            for(int j=0;j<M;j++){
                sum+=circle[N-1][j];
                if(circle[N-1][j]!=0) count++;
            }
            float avg=(float)sum/count;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(circle[i][j]==0) continue;
                    if(circle[i][j]<avg){
                        circle[i][j]++;
                    }else if(circle[i][j]>avg){
                        circle[i][j]--;
                    }
                }
            }
        }
    }static void print(){
        answer=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                answer+=circle[i][j];
                System.out.print(circle[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
