package eper;
import java.util.*;

public class ex_6 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		double n=scan.nextDouble();
		double m=scan.nextDouble();
		if (n==0) {
			double x=250.0*125.0/(250.0-m);
			double y=250.0-x;
			System.out.print(String.format("%.2f ", x)+String.format("%.2f", y));
		}else if (m==0) {
			double y=250.0*125.0/(250.0-n);
			double x=250.0-y;
			System.out.print(String.format("%.2f ", x)+String.format("%.2f", y));
		}else {
			if(n>125) {
				double x=0.0;
				double y=250.0-(250.0*125.0/n);
				System.out.print(String.format("%.2f ", x)+String.format("%.2f", y));
			}else {
				double y=0.0;
				double x=250.0-(250.0*125.0/m);
				System.out.print(String.format("%.2f ", x)+String.format("%.2f", y));
			}
		}
	}
}
