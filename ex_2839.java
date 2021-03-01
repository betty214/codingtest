package backjun;

import java.util.Scanner;

public class ex_2839 {
	public static int[] dpmemory;
	public static int result=0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(dpSweet(n,result));
	}

	public static int dpSweet(int n, int r) {
		if (n==3 || n==5) {
			return r;
		} else if (n%3==0) {
			
		} else if (n%5==0) {
			System.out.println(2);
		}
	}
}
