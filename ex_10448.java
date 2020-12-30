package backjun;

import java.util.Scanner;

public class ex_10448 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int f=0;
		int findnum[] = new int[n];
		for (int i = 0; i < n; i++) {
			findnum[i]=scan.nextInt();
		}for (int i = 0; i < n; i++) {
			f=FindTri(findnum[i]);
			System.out.println(f);
		}
	}

	public static int FindTri(int n) {
		int sum=0,flag=0;
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				for(int k=1;k<n;k++) {
					sum=(i*(i+1)/2)+(j*(j+1)/2)+(k*(k+1)/2);
					if (sum>n) {
						break;
					}else if (sum==n) {
						flag=1;
					}
				}
			}
		}
		return flag;
	}
}
