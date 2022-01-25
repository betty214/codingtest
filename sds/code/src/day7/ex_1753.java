package day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1753 {
    private static class Node implements Comparable<Node>{
        int end;
        int dist;
        public Node(int end, int dist){
            this.end=end;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist-o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day7/1753.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        PriorityQueue<Node>[]arr=new PriorityQueue[V+1];
        for(int i=1;i<=V;i++){
            arr[i]=new PriorityQueue<>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v,w));
        }
        PriorityQueue<Node>pq=new PriorityQueue<>();
        pq.offer(new Node(K,0));
        int []answer=new int[V+1];
        for(int i=0;i<V;i++){
            answer[i+1]=100000000;
        }
        boolean[] visited = new boolean[V + 1];
        answer[K] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.end]) continue;
            visited[now.end]=true;

            for(Node node : arr[now.end]){
                if(answer[node.end] > answer[now.end] + node.dist){
                    answer[node.end] = answer[now.end] + node.dist;
                    pq.add(new Node(node.end, answer[node.end]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(answer[i]==100000000) System.out.println("INF");
            else System.out.println(answer[i]);
        }
    }
}