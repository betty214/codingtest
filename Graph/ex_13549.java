package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_13549 {
    static boolean []visited;
    static int min=Integer.MAX_VALUE;
    private static class Node{
        int now;
        int cost;
        public Node(int now,int cost){
            this.now=now;
            this.cost=cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        visited=new boolean[100001];
        Dijkstra(N,K);
        System.out.println(min);
    }static int Dijkstra(int N,int K){
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(N,0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.now]=true;
            if(node.now == K) {
                min = Math.min(min, node.cost);
            }
            if(node.now * 2 <= 100000 && !visited[node.now * 2]){
                q.offer(new Node(node.now * 2, node.cost));
            }
            if(node.now + 1 <= 100000 && !visited[node.now + 1]){
                q.offer(new Node(node.now + 1, node.cost + 1));
            }
            if(node.now - 1 >= 0 && !visited[node.now - 1]) {
                q.offer(new Node(node.now - 1, node.cost + 1));
            }

        }return 0;
    }
}
