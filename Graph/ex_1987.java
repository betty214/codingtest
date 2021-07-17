package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1987 {
	static char [][]board;
	static boolean []visited;
	static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
	static int R,C,ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		board=new char[R][C];
		visited=new boolean[26];
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j]=s.charAt(j);
			}
		}DFS(0,0,0);
		System.out.println(ans);
	}static void DFS(int x, int y, int count) {
		if (visited[board[x][y] - 'A']) {
			ans = Math.max(ans, count); 
			return; 
		} else {
			visited[board[x][y] - 'A'] = true;
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
					DFS(cx, cy, count + 1);
				}
			}
			visited[board[x][y] - 'A'] = false;
		}
	}
}
