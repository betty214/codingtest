package eper;
import java.util.*;

public class ex_4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		if (m>n) {
			System.out.print((n-1)*2);
		}else {
			System.out.print((m-1)*2);
		}
	}
}
