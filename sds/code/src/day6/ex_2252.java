package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_2252 {
    private static class Node{
        int degree;
        int next;
        int index;
        public Node(int degree,int index){
            this.degree=degree;
            this.index=index;
        }
    }
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day6/2252.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[]g=new Node[N+1];
        boolean[]visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            g[i]=new Node(0,i);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            g[second].degree=g[first].degree+1;
            g[first].next=second;
        }
        Queue<Node>q=new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(g[i].degree==0)q.offer(g[i]);
        }
        while(!q.isEmpty()){
            Node now=q.poll();
            if(!visited[now.index]){
                System.out.print(now.index+" ");
                visited[now.index]=true;
                int n=now.next;
                while(n!=0){
                    g[n].degree--;
                    if(g[n].degree==0) q.offer(g[n]);
                    n=g[n].next;
                }
            }
        }
    }
}
