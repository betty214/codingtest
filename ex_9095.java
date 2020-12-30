package backjun;

import java.util.Scanner;

public class ex_9095 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int m = scan.nextInt();
	    int findnum[] = new int[m];
		for (int i = 0; i < m; i++) {
			findnum[i]=scan.nextInt();
		}
	    int DP[]=new int [11];
	    DP[1] = 1;
	    DP[2] = 2;
	    DP[3] = 4;

	    for(int i = 0; i < m; i++) {
	        for(int j = 4; j <= findnum[i]; j++) {
	            DP[j] = DP[j-1] + DP[j-2] + DP[j-3];
	        }
	    }
	    for(int i=0;i<m;i++) {
	    	System.out.println(DP[findnum[i]]);
	    }
	}
}
