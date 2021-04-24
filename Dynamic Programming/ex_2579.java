package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class ex_2579 {
	public static int [] stair;
    public static int [] dynamic;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stair=new int[N];
        for(int i=0;i<N;i++) {
        	stair[i]=sc.nextInt();
        }
        dynamic = new int [N];
        Arrays.fill(dynamic, -1);
        dynamic[0]=stair[0];
        if(N>1) {
        	dynamic[1]=stair[0]+stair[1];	
		}if(N>2){
			dynamic[2]=Math.max(stair[2]+stair[1],stair[0]+stair[2]);
		}
        up(N-1);
		System.out.println(dynamic[N-1]);
	}
	public static int up(int index) {
		if (dynamic[index]==-1){
    		dynamic[index]=Math.max(up(index-2),up(index-3)+stair[index-1])+stair[index];
    	}
		return dynamic[index];
	}
}
