package backjun;

import java.util.Scanner;

public class ex_1062 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int m = scan.nextInt();
	    String letter[] = new String[n];
	    char spell[][] = new char[50][15];
	    int flag=0,f=0;
	    for(int i=0;i<n;i++) {
	    	letter[i]= scan.next();
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<letter[i].length();j++) {
	    		char y=letter[i].charAt(j);
	    		if(y!='a'&&y!='n'&&y!='t'&&y!='i'&&y!='c') {
	    			for(int k=0;k<spell[i].length;k++) {
	    				if(y==spell[i][k]) {
	    					f=1;
	    				}
	    			}
	    			if(f==0) {
	    				spell[i][flag]=y;
		    			flag++;
	    			}f=0;
	    		}
	    	}flag=0;
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<spell[i].length;j++) {
		    	System.out.print(spell[i][j]);
	    	}System.out.println();
	    }
	    if(m<5) {
	    	System.out.println(0);
	    }
	}
}
