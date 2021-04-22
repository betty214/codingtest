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
        dynamic = new int [N+1];
        Arrays.fill(dynamic, -1);
        dynamic[0]=stair[0];
        dynamic[1]=stair[0]+stair[1];
        up(N-1);
        System.out.println(dynamic[N-1]);
	}
	public static int up(int index) {
		if(index==2) {
            dynamic[index]=Math.max(stair[1]+stair[2], stair[0]+stair[2]);
    	}else if(index==3) {
    		if(dynamic[2]==stair[1]+stair[2]) {
    			dynamic[index]=dynamic[1]+stair[3];
    		}else {
    			dynamic[index]=Math.max(dynamic[1]+stair[3], dynamic[2]+stair[3]);
    		}
    	}
		if (index>3){
    		if(up(index-1)==up(index-2)+stair[index-1]) {
    			dynamic[index]=up(index-2)+stair[index];
    		}else {
    			dynamic[index]=Math.max(up(index-2)+stair[index],up(index-1)+stair[index]);
    		}
    	}
		return dynamic[index];
	}
}
