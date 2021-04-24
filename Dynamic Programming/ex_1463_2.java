package backjun;

import java.util.Scanner;
import java.util.Arrays;

public class ex_1463_2 {
    public static int [] dynamic;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        dynamic = new int [X+1];
        Arrays.fill(dynamic, -1);
        make1(X);
        System.out.println(dynamic[X]);
	}
	public static int make1(int index) {
		if(index==1) {
			dynamic[index]=0;
		}else if(index==2 || index==3) {
			dynamic[index]=1;
		}
		if(dynamic[index]==-1) {
			if(index%3==0&&index%2!=0) {
				dynamic[index]=Math.min(make1(index-1), make1(index/3))+1;
			}else if(index%3!=0&&index%2==0) {
				dynamic[index]=Math.min(make1(index-1), make1(index/2))+1;
			}else if(index%3==0&&index%2==0) {
				int a = Math.min(make1(index/3), make1(index/2));
				dynamic[index]=Math.min(a, make1(index-1))+1;
			}else {
				dynamic[index]=1+make1(index-1);
			}
		}
		return dynamic[index];
	}
}
