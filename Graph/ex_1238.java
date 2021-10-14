package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1238 {
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());
        int []distance =new int[N+1];
        boolean []visited=new boolean[N+1];
        ArrayList<ArrayList<Node>>road=new ArrayList<>();
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<=N;i++){
            road.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            road.get(start).add(new Node(end,cost));
        }
        int max=0;
        for(int i=1;i<=N;i++){
            Arrays.fill(distance,Integer.MAX_VALUE);
            Arrays.fill(visited,false);
            if(i!=X){
                pq.offer(new Node(i,0));
                distance[i]=0;
                while(!pq.isEmpty()){
                    Node now = pq.poll();
                    int next = now.end;
                    if (!visited[next]) {
                        visited[next] = true;
                        for (Node node : road.get(next)) {
                            if (!visited[node.end] && distance[node.end] > distance[next] + node.cost) {
                                distance[node.end] = distance[next] + node.cost;
                                pq.add(new Node(node.end, distance[node.end]));
                            }
                        }
                    }
                }
                int sum=distance[X];
                Arrays.fill(distance,Integer.MAX_VALUE);
                Arrays.fill(visited,false);
                pq.offer(new Node(X,0));
                distance[X]=0;
                while(!pq.isEmpty()){
                    Node now = pq.poll();
                    int next = now.end;
                    if (!visited[next]) {
                        visited[next] = true;
                        for (Node node : road.get(next)) {
                            if (!visited[node.end] && distance[node.end] > distance[next] + node.cost) {
                                distance[node.end] = distance[next] + node.cost;
                                pq.add(new Node(node.end, distance[node.end]));
                            }
                        }
                    }
                }
                sum+=distance[i];
                max=Math.max(max,sum);
            }
        }
        System.out.println(max);
    }
}
