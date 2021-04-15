package backjun;

import java.util.Scanner;

public class ex_2231 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int mingen=0;

		for (int i = 1; i < n; i++) {
			if(FindGenerator(n,i)) {
				mingen=i;
				break;
			}
		}

		System.out.println(mingen);

	}

	public static boolean FindGenerator(int n,int m) {
		int length = (int)(Math.log10(m)+1);
		int sum=m;
		String number = Integer.toString(m);
		for (int i=0;i<length;i++) {
			sum+=Integer.parseInt(number.substring(i, i+1));
		}
		if (sum==n) {
			return true;
		}
		else
			return false;
	}
}
