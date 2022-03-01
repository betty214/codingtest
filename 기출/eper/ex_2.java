package eper;
import java.util.Scanner;
import java.util.ArrayList;

public class ex_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		ArrayList score = new ArrayList();
		int sum=0;
		for(int i=0; i<num; i++) {
			int n=scan.nextInt();
			sum+=n;
			score.add(n);
		}
		sum=sum/num;
		int number=0;
		for(int i=0; i<num; i++) {
			if ((int)(score.get(i))>sum) {
				number++;
			}
		}
		double ans=(double)number/(double)num*100;
		System.out.println(String.format("%.3f", ans)+"%");
		scan.close();
	}
}
