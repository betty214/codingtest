package backjun;

import java.util.Scanner;

public class ex_1062 {
	public static char save[] = new char[10];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int m = scan.nextInt();
	    String letter[] = new String[n];
	    char spell[][] = new char[50][15];
	    int length[]=new int[n];
	    int flag=0,f=0,max=0,lflag=0;
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
	    				lflag++;
		    			flag++;
	    			}f=0;
	    		}length[i]=lflag;
	    	}flag=0;
	    	lflag=0;
	    }
	    for(int i=0;i<n;i++) {
	    	System.out.println(length[i]);
	    }
	    
	    if(m<5) {
	    	System.out.println(0);
	    }else {
	    	max=FindMax(n,m,spell,length);
	    	System.out.println(max);
	    }
	}

	public static int FindMax(int n, int m, char s[][],int length[]) {
		for (int j = 1; j <= (m - n); j++) {
			for (int i = 0; i < n; i++) {
				CheckMax(j,s[i],length[i]);
			}
		}
		
		for(int i=0;i<10;i++) {
			System.out.print(save[i]+" ");
		}
		return 1;
	}
	
	public static void CheckMax(int length, char st[], int len) {
		int flag=0,index=0;
		
		if (len == length) {
			for(int i=0;i<length;i++) {
				for(int j=0;j<10;j++) {
					if(st[i]==save[j]) {
						flag=1;
					}
				}if(flag==0) {
					save[index]=st[i];
					index++;
				}
			}
		}
	}
}
