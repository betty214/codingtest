package backjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_2206 {
	static int[][] wall;
	public static boolean[][][] visited;
	public static int N, M, ans;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static class W{
		int x;
		int y;
		int cnt;
		int br;
		
		public W(int x,int y, int cnt, int br) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.br=br;
		}
	}
	public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall=new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                wall[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        } ans = Integer.MAX_VALUE;
        bfs();
        if(ans==Integer.MAX_VALUE) {
        	System.out.println(-1);
        }else {
        	System.out.println(ans);
        }
	}	
	 public static void bfs() {
	        Queue<W> q = new LinkedList<W>();
	        q.offer(new W(0, 0, 1, 0));
	 
	        while (!q.isEmpty()) {
	 
	            W node = q.poll();
	            int x = node.x;
	            int y = node.y;
	            int cnt = node.cnt;
	            int br = node.br;
	 
	            if (x == N-1 && y == M-1) {
	                ans = Math.min(ans, cnt);
	                continue;
	            }
	 
	            for (int i = 0; i < 4; i++) {
	                int cx = x+dx[i];
	                int cy = y+dy[i];
	 
	                if ((cx >= 0 && cx < N) && (cy >= 0 && cy < M)) {
	                    if (br == 1) {
	                        if (!visited[br][cx][cy] && wall[cx][cy] == 0) {
	                        	visited[br][cx][cy] = true;
	                            q.offer(new W(cx, cy, cnt + 1, br));
	                        }
	 
	                    } else { 
	                        if (wall[cx][cy] == 1) {
	                            if (!visited[br+1][cx][cy]) {
	                            	visited[br+1][cx][cy] = true;
	                                q.offer(new W(cx, cy, cnt + 1, br+1));
	                            }
	                        } else if (wall[cx][cy] == 0) {
	                            if (!visited[br][cx][cy]) {
	                            	visited[br][cx][cy] = true;
	                                q.offer(new W(cx, cy, cnt + 1, br));
	                            }
	                        }
	                    }
	                }
	 
	            }
	 
	        }
	    }
}
