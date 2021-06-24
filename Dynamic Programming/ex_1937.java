package backjun;

import java.util.Scanner;

public class ex_1937 {
	static int max,N,count,answer;
	static int [][]Bamboo,DP;
	static int dx[] = {0,0,1,-1};
    static int dy[] = {-1,1,0,0};
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Bamboo = new int[N][N];
        DP=new int[N][N];
        max=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		Bamboo[i][j] = scan.nextInt();
        		if(Bamboo[i][j]>max) {
        			max=Bamboo[i][j];
        		}
        	}
        }
        answer=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		count=0;
        		int n = Panda(i,j);
        		if(n>answer) {
        			answer=n;
        		}
        		DP[i][j]=n;
        	}
        }
        System.out.println(answer+1);
	}public static int Panda(int x, int y) {
		if(DP[x][y]!=0) {
			return DP[x][y];
		}
		for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx>-1 && cy>-1 && cx<N && cy<N && Bamboo[cx][cy]>Bamboo[x][y]){
            	DP[x][y] = Math.max(DP[x][y], Panda(cx, cy) + 1);
            }
        }
		
		return DP[x][y];
	}
}
