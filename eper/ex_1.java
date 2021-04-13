package eper;
import java.util.Scanner;

public class ex_1 {
	public static void main(String[] args) {
		final double rate = 1100.0;
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		if (year%400==0) {
			System.out.println("T");
		}else if (year%4==0 && year%100!=0) {
			System.out.println("T");
		}else {
			System.out.println("F");
		}
		scanner.close();
	}
}
