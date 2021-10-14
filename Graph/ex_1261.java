package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1261 {
    static int []dx={0,0,1,-1};
    static int []dy={1,-1,0,0};
    static int r,c;
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int sum;
        public Node(int x,int y, int sum) {
            this.x = x;
            this.y=y;
            this.sum = sum;
        }
        @Override
        public int compareTo(Node o) {
            return sum- o.sum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<Node>pq=new PriorityQueue<>();
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        int[][]maze=new int[c+1][r+1];
        boolean[][]visited=new boolean[c+1][r+1];
        for(int i=1;i<=c;i++){
            String input=br.readLine();
            for(int j=1;j<=r;j++){
                maze[i][j]=Integer.parseInt(input.substring(j-1,j));
            }
        }
        pq.offer(new Node(1,1,0));
        visited[1][1]=true;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            if(now.x==c &&now.y==r){
                System.out.println(now.sum);
                break;
            }
            for(int i=0;i<4;i++){
                int cx=dx[i]+now.x;
                int cy=dy[i]+now.y;
                if(check(cx,cy)){
                    if(!visited[cx][cy]){
                        visited[cx][cy] = true;
                        pq.offer(new Node(cx, cy, now.sum+maze[cx][cy]));
                    }
                }
            }
        }
    }static boolean check(int x,int y){
        if(x>c||y>r||x<=0||y<=0){
            return false;
        }
        return true;
    }
}
