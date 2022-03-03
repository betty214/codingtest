package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14503 {
    static int[] dx={0,-1,0,1};
    static int[] dy={-1,0,1,0};
    static int N,M;
    static int [][]room;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14503.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                room[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int tempD=d;
        int answer=0;
        int count=0;
        while(true){
            if(visited[r][c]) break;
            if(room[r][c]==0) {
                room[r][c]=2;
                answer++;
                count=0;
                visited[r][c]=true;
            }
            int cx=r+dx[tempD];
            int cy=c+dy[tempD];
            if(room[cx][cy]==0){
                r=cx;
                c=cy;
            }else{
                tempD--;
                count++;
                if(tempD==-1) tempD=3;
                if(count==4){
                    if(room[r-dx[tempD]][c-dy[tempD]]!=1){
                        r-=dx[tempD];
                        c-=dy[tempD];
                    } else{
                        break;
                    }
                }
            }

        }
        print();
        System.out.println(answer);
    }static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
    }
}
