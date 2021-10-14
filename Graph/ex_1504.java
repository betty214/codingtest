package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1504 {
    private static class Node implements Comparable<Node>{
        int end;
        int cost;
        public Node(int end,int cost){
            this.end=end;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o) {
            return cost-o.cost;
        }
    }
    static PriorityQueue<Node> pq;
    static int []distance;
    static ArrayList <ArrayList<Node>>path;
    static boolean [] visited;
    static final int INF = 200000000;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        path = new ArrayList<>();
        pq=new PriorityQueue<>();
        visited = new boolean[N+1];
        distance =new int[N+1];
        for (int i = 0; i <= N; i++) {
            path.add(new ArrayList<>());
        }
        Arrays.fill(distance,INF);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            path.get(start).add(new Node(end,cost));
            path.get(end).add(new Node(start,cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());

        int answer=Dijkstra(1,v1)+Dijkstra(v1,v2)+Dijkstra(v2,N);
        answer=Math.min(answer,Dijkstra(1,v2)+Dijkstra(v2,v1)+Dijkstra(v1,N));
        if(answer>=INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }static int Dijkstra(int s,int e){
        Arrays.fill(distance,INF);
        Arrays.fill(visited,false);
        pq.offer(new Node(s,0));
        distance[s]=0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int next = now.end;
            if (!visited[next]) {
                visited[next] = true;
                for (Node node : path.get(next)) {
                    if (!visited[node.end] && distance[node.end] > distance[next] + node.cost) {
                        distance[node.end] = distance[next] + node.cost;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }return distance[e];
    }
}
