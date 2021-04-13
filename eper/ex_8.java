package eper;
import java.util.*;

public class ex_8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n,m,count=0;
		n=scan.nextInt();
		m=scan.nextInt();
		int cur_tomato[][]=new int[m+2][n+2];
		for(int i=0;i<m+2;i++) {
			cur_tomato[i][0]=-1;
			cur_tomato[i][n+1]=-1;
		}
		for(int j=0;j<n+2;j++) {
			cur_tomato[0][j]=-1;
			cur_tomato[m+1][j]=-1;
		}
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				cur_tomato[i][j]=scan.nextInt();
			}
		}
		int new_tomato[][]=new int[m+2][n+2];
		for(int i=0;i<m+2;i++) {
			for(int j=0;j<n+2;j++) {
				new_tomato[i][j]=cur_tomato[i][j];
			}
		}
		int flag=1;
		while(flag==1) {
			flag=0;
			for(int i=1;i<m+1;i++) {
				for(int j=1;j<n+1;j++) {
					if(cur_tomato[i][j]==1) {
						if(cur_tomato[i-1][j]==0) {
							new_tomato[i-1][j]=1;
							flag=1;
						}if(cur_tomato[i+1][j]==0) {
							new_tomato[i+1][j]=1;
							flag=1;
						}if(cur_tomato[i][j-1]==0) {
							new_tomato[i][j-1]=1;
							flag=1;
						}if(cur_tomato[i][j+1]==0) {
							new_tomato[i][j+1]=1;
							flag=1;
						}
					}
				}
			}if(flag==1) {
				count++;
				for(int k=0;k<m+2;k++) {
					for(int t=0;t<n+2;t++) {
						cur_tomato[k][t]=new_tomato[k][t];
					}
				}
			}
		}
		for(int k=0;k<m+2;k++) {
			for(int t=0;t<n+2;t++) {
				if(cur_tomato[k][t]==0) {
					count=-1;
				}
			}
		}
		System.out.println(count);
	}
}
