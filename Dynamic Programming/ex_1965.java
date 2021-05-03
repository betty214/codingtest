package backjun;

import java.util.Scanner;
import java.util.Arrays;
public class ex_1965 {
	public static int []dp,cost;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new int[n+1];
		cost = new int[n+1];
        Arrays.fill(dp,1);
		for(int i=1;i<=n;i++) {
			cost[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(cost[i]>cost[j]&&dp[j]+1>dp[i]) { 
						dp[i]=dp[j]+1;
				}
			}
		}
		int max=-1;
		for(int i=1;i<n+1;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
		}System.out.print(max);
		
		}
}
