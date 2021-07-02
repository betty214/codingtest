package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_17144 {
	static int R,C,T,c1,c2,answer;
	static int[][]room,temp;
	static int []tr= {0,0,1,-1};
	static int []tc= {1,-1,0,0};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room=new int[R][C];
		temp=new int[R][C];
		int flag=0;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				room[i][j]= Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					if(flag==0) {
						c1=i;
						flag=1;
					}else {
						c2=i;
					}
				}
			}
		}
		for(int i=0;i<T;i++) {
			spread();
			/*
			for(int k=0;k<R;k++) {
				for(int j=0;j<C;j++) {
					System.out.print(room[k][j]+" ");
				}System.out.println();
			}
			System.out.println();*/
			init();
			clean();
			init();
			/*
			for(int k=0;k<R;k++) {
				for(int j=0;j<C;j++) {
					System.out.print(room[k][j]+" ");
				}System.out.println();
			}System.out.println();*/
		}
		
		count();
		System.out.println(answer);
	}public static void init() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				temp[i][j]=0;
			}
		}
	}public static void count() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]!=-1) {
					answer+=room[i][j];
				}
			}
		}
	}
	public static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]==0)
					continue;
				else if(room[i][j]==-1){
					temp[i][j]=-1;
				}
				else{
					int out=0;
					for(int k=0;k<4;k++) {
						int cx=i+tr[k];
						int cy=j+tc[k];
						if(cx>=0&&cy>=0&&cx<R&&cy<C) {
							if((cx==c1&&cy==0)||(cx==c2&&cy==0))
								continue;
							else {
								temp[cx][cy]+=room[i][j]/5;
								out+=room[i][j]/5;
							}
						}
					}temp[i][j]-=out;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]==-1) {
					continue;
				}else {
				room[i][j]+=temp[i][j];
				}
			}
		}
	}public static void clean() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(i==0) {
					if(j==0) {
						temp[1][0]=room[0][0];
					}else {
						temp[i][j-1]=room[i][j];
					}
				}else if(j==C-1) {
					if(i<=c1&&i>0) {
						temp[i-1][j]=room[i][j];
					}else if(i>=c2&&i<R-1){
						temp[i+1][j]=room[i][j];
					}else if(i==R-1) {
						temp[i][j-1]=room[i][j];
					}
				}else if(i==c1||i==c2) {
					if(j>0&&j<C-1) {
						temp[i][j+1]=room[i][j];
					}else if(j==0) {
						temp[i][j]=room[i][j];
					}
				}else if(i==R-1) {
					if(j==0) {
						temp[R-2][0]=room[R-1][0];
					}else {
						temp[i][j-1]=room[i][j];
					}
				}else if(j==0){
					if(i<c1-1&&i>0) {
						temp[i+1][j]=room[i][j];
					}else if(i>c2+1&&i<R){
						temp[i-1][j]=room[i][j];
					}
				}else {
					temp[i][j]=room[i][j];
				}
			}
		}for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				room[i][j]=temp[i][j];
			}
		}
	}
}
