package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_16234 {
    static int N;
    static int [][]country;
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/16234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        country=new int[N][N];
        boolean[][]visited;
        int[]dx={1,-1,0,0};
        int[]dy={0,0,1,-1};
        boolean flag=true;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                country[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;

        while (flag) {
            visited =new boolean[N][N];
            flag=false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Queue<Node>q=new LinkedList<>();
                    Queue<Node>temp=new LinkedList<>();
                    int sum=0;
                    if(visited[i][j]) continue;
                    q.add(new Node(i,j));

                    while(!q.isEmpty()){
                        Node now = q.poll();

                        temp.add(now);
                        sum+=country[now.x][now.y];

                        for(int k=0;k<4;k++){
                            int cx=dx[k]+now.x;
                            int cy=dy[k]+now.y;
                            visited[now.x][now.y]=true;
                            if(check(cx,cy)) {
                                int diff=Math.abs(country[now.x][now.y]-country[cx][cy]);
                                if(diff>=L && diff<=R && !visited[cx][cy]) {
                                    q.add(new Node(cx,cy));
                                    visited[cx][cy]=true;
                                    flag=true;
                                }
                            }
                        }
                    }
                    if(sum!=country[i][j]&&!temp.isEmpty()){
                        int s=(int) sum/temp.size();

                        while(!temp.isEmpty()){
                            Node now = temp.poll();
                            country[now.x][now.y]=s;
                        }
                    }
                }
            }
            answer++;
        }
        System.out.println(answer-1);
    }static boolean check(int x,int y){
        if(x<0||y<0||x>=N||y>=N) return false;
        return true;
    }static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(country[i][j]+" ");
            }
            System.out.println();
        }
    }
}
