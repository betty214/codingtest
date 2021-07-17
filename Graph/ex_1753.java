package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class ex_1753 {    
    static ArrayList<Node>[] list;
    static int [] dist;
    static int V;
    private static int INF = 100_000_000;
    static class Node implements Comparable<Node>{
        int end;
        int cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1]; 
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for(int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < E; i++) {
        	st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
        }
        dijkstra(K);
        for(int i = 1; i <= V; i++){
            if(dist[i] == INF) 
            	System.out.println("INF");
            else
            	System.out.println(dist[i]);
        }

    }
    
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(visited[cur] == true) 
            	continue;
            visited[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.cost){
                    dist[node.end] = dist[cur] + node.cost;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
     }
    
}
