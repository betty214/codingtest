package backjun;

import java.util.Scanner;
import java.util.Arrays;

public class ex_2309 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int small[] = new int[9];
	    int f=0;
	    for(int i=0;i<9;i++) {
	    	small[i]= scan.nextInt();
	    }
	    loop:
	    for(int i=0;i<9;i++) {
	    	for(int j=i+1;j<9;j++) {
		    	f=FindSmall(i,j,small);
		    	if(f==100) {
		    		MakeSmall(i,j,small);
		    		break loop;
		    	}
	    	}
	    }
	    scan.close();
	}public static int FindSmall(int n,int m, int s[]) {
		int sum=0;
		for(int i=0;i<9;i++) {
			if(i!=n&&i!=m) {
				sum+=s[i];
			}
		}
		return sum;
	}public static void MakeSmall(int n,int m, int s[]) {
		int fake[]=new int [7];
		int flag=0;
		for(int i=0;i<9;i++) {
			if(i!=n&&i!=m) {
				fake[flag]=s[i];
				flag++;
			}
		}
		Arrays.sort(fake);
		for(int i=0;i<7;i++) {
		    System.out.println(fake[i]);
		}
	}
}
