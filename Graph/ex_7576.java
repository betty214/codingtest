package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_7576 {
	static int [][]tomato;
	static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int N,M;
    private static class Node {
        int x;
        int y;
        int day;
        
        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		tomato=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tomato[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}static void bfs() {
        Queue<Node> q = new LinkedList<Node>();
        int day = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j] == 1) 
                    q.offer(new Node(i, j, 0));
            }
        }
        while(!q.isEmpty()) {
            Node t = q.poll();
            day = t.day;
 
            for(int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
 
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        q.add(new Node(nx, ny, day+1));
                    }
                }
            }
        } 
        int flag=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j] == 0) {
                	flag=1;
                }
            }
        }
        if(flag==0)
            System.out.println(day);
        else
            System.out.println(-1);
    }   
}
