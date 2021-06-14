package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1743 {
	public static int [][] trash,visited;
	public static int max,count,N,M;
	public static int dx[] = {0,0,1,-1};
    public static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		trash=new int[N][M];
		visited=new int[N][M];
		
		max=0;count=0;
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			trash[x-1][y-1]=1;
		}
		for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                count = 1;
                if(visited[i][j]==0 && trash[i][j] == 1)
                    if(DFS(i,j) > max)
                        max = DFS(i,j);
            }
        }
        System.out.println(max);
	}public static int DFS(int x, int y){
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(isRangeTrue(row,col) && visited[row][col]==0 && trash[row][col] == 1){
                DFS(row,col);
                count++;
            }
        }
    return count;
    }
 
    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
