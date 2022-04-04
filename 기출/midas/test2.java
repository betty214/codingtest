package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {
    static boolean [][]visited;
    static class Node{
        int x1;
        int x2;
        int y1;
        int y2;
        public Node(int x1, int x2, int y1, int y2){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x1=" + x1 +
                    ", x2=" + x2 +
                    ", y1=" + y1 +
                    ", y2=" + y2 +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/test2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][]L=new int[3][4];
        Node[] n = new Node[L.length];
        visited=new boolean[32767][2];
        int answer=0;

        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                L[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<L.length;i++){
            int x1=Math.min(L[i][0],L[i][2]);
            int x2=Math.max(L[i][0],L[i][2]);
            int y1=Math.min(L[i][1],L[i][3]);
            int y2=Math.max(L[i][1],L[i][3]);
            for(int j=x1;j<=x2;j++){
                visited[j][0]=true;
            }
            for(int j=y1;j<=y2;j++){
                visited[j][1]=true;
            }
            n[i]=new Node(x1,x2,y1,y2);
        }
        for(int i=0;i<L.length-1;i++){
            for(int j=i+1;j<L.length;j++){
                if(!check(n[i],n[j])){
                    int add=Math.min(move(n[j],n[i]),move(n[i],n[j]));
                    answer+=add;
                }
            }
        }
        System.out.println(answer);
    }static boolean check(Node a, Node b){
        if(b.x2>=a.x1 && a.x2>=b.x1 && a.y2>=b.y1 && b.y2>=a.y1) return false;
        else return true;
    }static int move(Node a, Node b){
        System.out.println(a);
        System.out.println(b);
        int xDiff=Integer.MAX_VALUE;
        int yDiff=Integer.MAX_VALUE;
        if(!visited[a.x2+b.x2-a.x1][0]) {
            xDiff=Math.min(xDiff,b.x2-a.x1);
            System.out.println("우");
            System.out.println(xDiff);
        }
        if(!visited[a.x2+b.x1-a.x2][0]) {
            xDiff=Math.min(xDiff,a.x2-b.x1);
            System.out.println("좌");
            System.out.println(xDiff);
        }
        if(!visited[2*b.y2-a.y1][0]) {
            yDiff=Math.min(yDiff,b.y2-a.y1);
            System.out.println("상");
            System.out.println(yDiff);
        }
        if(!visited[2*b.y1-a.y2][0]) {
            yDiff=Math.min(yDiff,a.y2-b.y1);
            System.out.println("하");
            System.out.println(yDiff);
        }
        return Math.min(xDiff,yDiff);
    }
}
