package backjun;

import java.util.Scanner;

public class ex_3085 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    String candy[] = new String[n];
	    int max=0,f=0;
	    for(int i=0;i<n;i++) {
	    	candy[i]= scan.next();
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n-1;j++) {
	    		f=ChangeCandy1(i,j,n,candy);
	    		if(max<f) {
	    			max=f;
	    		}
	    	}
	    }
	    for(int i=0;i<n-1;i++) {
	    	for(int j=0;j<n;j++) {
	    		f=ChangeCandy2(i,j,n,candy);

	    		if(max<f) {
	    			max=f;
	    		}
	    	}
	    }
	    System.out.println(max);
	    scan.close();
	}
	public static int ChangeCandy1(int n,int m,int cnt,String c[]) {
		char fakecandy[][] = new char[cnt][cnt];
		int maxnum=0;
		for(int i=0;i<cnt;i++) {
			for(int j=0;j<cnt;j++) {
				if(i==n&&j==m) {
					fakecandy[i][j]=c[i].charAt(j+1);
					fakecandy[i][j+1]=c[i].charAt(j);
					j++;
				}else {
					fakecandy[i][j]=c[i].charAt(j);
				}
			}
		}
		maxnum=FindCandy(cnt,fakecandy);
		return maxnum;
	}
	public static int ChangeCandy2(int n,int m,int cnt,String c[]) {
		char fakecandy[][] = new char[cnt][cnt];
		int maxnum=0;
		for(int j=0;j<cnt;j++) {
			for(int i=0;i<cnt;i++) {
				if(i==n&&j==m) {
					fakecandy[i][j]=c[i+1].charAt(j);
					fakecandy[i+1][j]=c[i].charAt(j);
					i++;
				}else {
					fakecandy[i][j]=c[i].charAt(j);
				}
			}
		}
		maxnum=FindCandy(cnt,fakecandy);
		return maxnum;
	}
	public static int FindCandy(int n,char fc[][]) {
		int maxnum1=0,maxnum2=0;
		int flag=1;
		for(int i=0;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(fc[i][j]==fc[i][j-1]) {
					flag++;
				}else {
					flag=1;
				}
				if(maxnum1<flag) {
					maxnum1=flag;
				}
			}flag=1;
		}
		flag=1;
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < n; i++) {
				if (fc[i][j] == fc[i - 1][j]) {
					flag++;
				}else {
					flag=1;
				}if(maxnum1<flag) {
					maxnum1=flag;
				}
					
			}flag=1;

		}
		return Math.max(maxnum1, maxnum2);
	}
}
