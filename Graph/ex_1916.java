package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1916 {
    private static class Node implements Comparable<Node>{
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
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        ArrayList <ArrayList<Node>>bus = new ArrayList<>();
        PriorityQueue<Node>pq=new PriorityQueue<>();
        boolean [] visited = new boolean[N+1];
        int []distance =new int[N+1];
        for (int i = 0; i <= N; i++) {
            bus.add(new ArrayList<>());
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            bus.get(start).add(new Node(end,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start_city=Integer.parseInt(st.nextToken());
        int end_city=Integer.parseInt(st.nextToken());
        pq.offer(new Node(start_city,0));
        distance[start_city]=0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int next = now.end;
            if (!visited[next]) {
                visited[next] = true;
                for (Node node : bus.get(next)) {
                    if (!visited[node.end] && distance[node.end] > distance[next] + node.cost) {
                        distance[node.end] = distance[next] + node.cost;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        System.out.println(distance[end_city]);
    }
}
