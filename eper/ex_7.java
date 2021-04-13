package eper;
import java.util.*;

public class ex_7 {
	public static void main(String[] args) {
		int r,c,z1,z2;
		Scanner scan = new Scanner(System.in);
		r=scan.nextInt();
		c=scan.nextInt();
		z1=scan.nextInt();
		z2=scan.nextInt();
		String[][] news=new String[r][c];
		for (int i=0;i<r;i++) {
				String s=scan.next();
				news[i]=s.split("");
		}
		for (int i=0;i<r;i++) {
			for(int k=0;k<z1;k++) {
				for(int j=0;j<c;j++) {
					for(int f=0;f<z2;f++) {
						System.out.print(news[i][j]);
					}
				}
				System.out.println();
			}
		}
	}
}
