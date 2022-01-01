package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test_5 {
    private static int INF = 100_000_000;
    static ArrayList<Node>[] graph;
    static int[][] road;
    static int N;
    static int[]distance;
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 1; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                graph[A].add(new Node(B, C));
                graph[B].add(new Node(A, C));
            }
            int min=Integer.MAX_VALUE;
            int count=0;
            for(int j=1;j<=N;j++){
                distance = new int[N + 1];
                Arrays.fill(distance, INF);
                dijkstra(j);
                int sum=0;
                for(int k=1;k<=N;k++){
                    if(distance[k]!=INF) sum+=distance[k];
                }if(min>sum && sum!=0){
                    min=sum;
                    count=1;
                }else if(min==sum){
                    count++;
                }
            }System.out.println("#"+(i+1)+" "+count+" "+min);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(start, 0));
        distance[start] = 0;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(visited[cur] == true)
                continue;
            visited[cur] = true;

            for(Node node : graph[cur]){
                if(distance[node.end] > distance[cur] + node.cost){
                    distance[node.end] = distance[cur] + node.cost;
                    queue.add(new Node(node.end, distance[node.end]));
                }
            }
        }
    }
}