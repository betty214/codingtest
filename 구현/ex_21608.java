package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_21608 {
    static int N;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][]blank,seat,like;
    private static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        like =new int[N*N+1][5];
        seat =new int[N+1][N+1];
        blank =new int[N+1][N+1];
        ArrayList<ArrayList<Node>>student =new ArrayList<>();
        fill_blank();
        for (int i = 1; i <= N*N; i++) {
            student.add(new ArrayList<>());
        }
        for(int i=0;i<N*N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            like[i][0]=Integer.parseInt(st.nextToken());
            like[i][1]=Integer.parseInt(st.nextToken());
            like[i][2]=Integer.parseInt(st.nextToken());
            like[i][3]=Integer.parseInt(st.nextToken());
            like[i][4]=index;
            student.get(index).add(new Node(-1,-1,));
        }for(int i=0;i<N*N;i++){
            for(int j=0;j<4;j++){
                Node friend=student.get(like[i][j]);
            }
        }
    }
    static void fill_blank(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int count=0;
                for(int k=0;k<4;k++){
                    int cx=i+dx[k];
                    int cy=j+dy[k];
                    if(check(cx,cy)){
                        if(seat[cx][cy]==0){
                            count++;
                        }
                    }
                }blank[i][j]=count;
            }
        }
    }
    static boolean check(int x,int y){
        if(x<=0||y<=0||x>N||y>N){
            return false;
        }else{
            return true;
        }
    }
}
