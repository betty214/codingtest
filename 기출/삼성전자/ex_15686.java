package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_15686 {
    static int N,M,index,answer;
    static int[][]city;
    static ArrayList<Node>home;
    static boolean []visited;
    static Node[]chicken;
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city=new int[N][N];
        chicken=new Node[13];
        visited=new boolean[13];
        home=new ArrayList<>();
        index=0;
        answer=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j]==1) home.add(new Node(i,j));
                else if(city[i][j]==2) chicken[index++]=new Node(i,j);
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }static void comb(int depth,int start){
        if(depth==M){
            answer=Math.min(answer,getDist());
            return;
        }

        for(int i=start;i<index;i++){
            visited[i]=true;
            comb(depth+1,i+1);
            visited[i]=false;
        }
    }static int getDist(){
        int dist=0;
        for(int i=0;i<home.size();i++){
            Node h = home.get(i);
            int now=Integer.MAX_VALUE;
            for(int j=0;j<index;j++){
                if(!visited[j]) continue;
                Node c = chicken[j];
                int temp=(Math.abs(h.x-c.x)+Math.abs(h.y-c.y));
                now=Math.min(now,temp);
            }
            dist+=now;
        }
        return dist;
    }
}
