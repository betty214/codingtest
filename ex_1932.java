package backjun;

import java.util.Scanner;

public class ex_1932 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] tri=new int [n][n];
        int[][] dynamic = new int[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<=i;j++) {
        		tri[i][j]=scan.nextInt();
        		if(i==n-1) {
        			dynamic[n-1][j]=tri[i][j];
        		}
        	}
        }
        for(int i=(n-2);i>=0;i--) {
        	for(int j=0;j<=i;j++) {
            	dynamic[i][j]=tri[i][j]+Math.max(dynamic[i+1][j], dynamic[i+1][j+1]);
        	}
        }
        System.out.println(dynamic[0][0]);
	}
}
