package algo;

import java.util.Scanner;

public class picnic {
	public static boolean [][] areFriends= new boolean [10][10]; 
	public static boolean []taken = new boolean[10];
	public static int ret = 0; 
	public static int countPairings(boolean taken[]) { 
		int firstFree = -1; 
		for(int i = 0; i < 4; i++) { 
			if(!taken[i]) {
				firstFree = i;
				break; 
			} 
		} 
		if(firstFree == -1) {
			return 1; 
		}
		for(int pairWith=firstFree+1;pairWith< 4; pairWith++) {  
			if(!taken[pairWith] && areFriends[firstFree][pairWith]){
				taken[firstFree] = true;
				taken[pairWith] = true; 
				ret+=countPairings(taken); 
				taken[firstFree] = false;
				taken[pairWith] = false; 
		} 
	}return ret;
	}
	public static void init() {
		for(int i=0;i<10;i++) {
	    	for(int j=0;j<10;j++) {
	    	    areFriends[i][j]=false;
	    	}taken[i]=false;
	    }
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int C = scan.nextInt();
	    for(int i=0;i<C;i++) {
	    	int n = scan.nextInt();
		    int m = scan.nextInt();
		    init();
		    for(int j=0;j<m;j++) {
		    	int first = scan.nextInt();
			    int second = scan.nextInt();
			    areFriends[first][second]=true;
			    areFriends[second][first]=true;
		    }
		    System.out.println(countPairings(taken));
	    }
	}
}