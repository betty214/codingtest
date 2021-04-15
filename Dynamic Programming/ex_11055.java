package backjun;

import java.util.Scanner;

public class ex_11055 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int []array = new int[n];
	    int []DP=new int[n];
	    int []sum=new int[n];
	    for(int i=0;i<n;i++) {
	    	array[i]=scan.nextInt();
	    }
	    DP[0]=array[0];
	    sum[0]=array[0];
	    
	    for(int i=1;i<n;i++) {
	    	int fnum=array[i];
	    	sum[i]=array[i];
	    	for(int j=i-1;j>=0;j--) {
	    		if(array[j]<fnum) {
	    			fnum=array[j];
	    			sum[i]+=array[j];
	    		}
	    	}
	    }
	    int max=sum[0];
	    for(int i=1;i<n;i++) {
	    	System.out.print(sum[i]+" ");
	    }
	    System.out.print(max);
	}
}
