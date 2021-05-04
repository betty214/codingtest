package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
public class ex_1012 {
	public static int [][]bechu,visited;
	public static int count,M,N,K;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringTokenizer st2;
		M=0;N=0;K=0;
		for(int i=0;i<T;i++) {
			st=new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			bechu=new int[M][N];
			visited=new int[M][N];
			K = Integer.parseInt(st.nextToken());
			for(int j=0;j<K;j++) {
				st2=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st2.nextToken());
				int b=Integer.parseInt(st2.nextToken());
				bechu[a][b]=1;
			}
			count=0;
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (bechu[x][y] == 1 && visited[x][y]==0) {
						bfs(x, y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
	public static void bfs(int x, int y) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { x, y });
		while (!qu.isEmpty()) {
			x = qu.peek()[0];
			y = qu.peek()[1];
			visited[x][y] = 1;
			qu.poll();
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (visited[cx][cy]==0 && bechu[cx][cy] == 1) {
						qu.add(new int[] { cx, cy });
						visited[cx][cy] = 1;
					}
				}
			}
		}
	}
}
