package eper;
import java.util.*;

public class ex_9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n,k=0,sum=0;
		n=scan.nextInt();
		int tri[][]=new int[n][n];
		int sol[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			k++;
			for(int j=0;j<k;j++) {
				tri[i][j]=scan.nextInt();
			}
		}
		sol[0][0]=tri[0][0];
		for(int i=1;i<n;i++) {
			sol[i][0]=tri[i][0]+sol[i-1][0];
			sol[i][i]=tri[i][i]+sol[i-1][i-1];
		}
		
		for (int i = 2; i < n; i++) {
		    for (int j = 1; j < i; j++) {
		        sol[i][j] = Math.max(sol[i - 1][j - 1], sol[i - 1][j]) + tri[i][j];
		    }
		}
		int max_sum=sol[n-1][0];
		for(int i=1;i<n;i++) {
			if(max_sum<sol[n-1][i]) {
				max_sum=sol[n-1][i];
			}
		}
		System.out.println(max_sum);
	}
}
