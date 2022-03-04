package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14503 {
    static int[] dx={0,-1,0,1};
    static int[] dy={-1,0,1,0};
    static int N,M,answer;
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
        answer=0;
        visited[r][c]=true;
        DFS(r,c,d,0);
        print();
        System.out.println(answer);
    }static void DFS(int x, int y, int dir,int count){
        System.out.println(x+" "+y+" "+count);
        if(room[x][y]==0) {
            room[x][y]=2;
            answer++;
        }
        int cx=x+dx[dir];
        int cy=y+dy[dir];
        if(room[cx][cy]==0 ){
            DFS(cx,cy,dir,count);
        }else{
            dir--;
            count++;
            if(dir==-1) dir=3;
            if(count==4){
                if(room[x-dx[dir]][y-dy[dir]]!=1){
                    x-=dx[dir];
                    y-=dy[dir];
                    count=0;
                }
            }
            if(!visited[x][y]){
                visited[x][y]=true;
                DFS(x,y,dir,count);
                visited[x][y]=false;
            }
        }
    }
    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
    }
}
