package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_4485 {
	 private static class Node implements Comparable<Node>{
	        int x;
	        int y;
	        int cost;
	        
	        public Node(int x, int y, int cost) {
	            this.x = x;
	            this.y = y;
	            this.cost = cost;
	        }
	        @Override
	        public int compareTo(Node o) {
	            return cost - o.cost;
	        }
	}
	static int [][]map,dist;
	static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int count=1;
		while(N!=0) {
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dijkstra(N);
			System.out.println("Problem "+count+": "+dist[N-1][N-1]);
			count++;
			N=Integer.parseInt(br.readLine());
		}
	}static void dijkstra(int N){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0, map[0][0]));
        dist[0][0] = map[0][0];

        while(!queue.isEmpty()){
            Node c = queue.poll();
            for(int i=0; i<4; i++){
                int cx = c.x + dx[i];
                int cy = c.y + dy[i];
                if(cx>=0 && cx<N && cy>=0 && cy<N && dist[cx][cy]==Integer.MAX_VALUE){
                	if(dist[cx][cy] > dist[c.x][c.y] + map[cx][cy]){
                		dist[cx][cy]  =  dist[c.x][c.y] + map[cx][cy];
                        queue.add(new Node(cx, cy, dist[cx][cy]));
                    }
                }
            }
           
        }
     }
}
