package backjun;
import java.util.Scanner;

public class ex_9202 {
	public static int flag;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int w = scan.nextInt();
	    String word[] = new String[w];
		for (int i = 0; i < w; i++) {
			word[i]=scan.next();
		}
	    int b = scan.nextInt();
	    String grid[][]=new String[b][4];
	    for (int i = 0; i < b; i++) {
	    	for(int j=0;j<4;j++) {
	    		grid[i][j]=scan.next();
	    	}
		}
	    for(int i=0;i<4;i++) {
	    	int s = grid[0][i].indexOf(word[0].charAt(0));
	    	if(s!=-1) {
	    		FindWord(i,s,grid,word[0],1);
	    	}
	    }
	    scan.close();
	}
	public static void FindWord(int i, int s,String grid[][], String find,int windex) {
			if(i!=0) {
				char a=grid[0][i-1].charAt(s);
				if(a==find.charAt(windex)) {
					if(windex==3) {
						System.out.println("성공");
					}else {
						FindWord(i-1,s,grid,find,windex+1);
					}
				}
			}if(i!=3) {
				char a=grid[0][i+1].charAt(s);
				if(a==find.charAt(windex)) {
					if(windex==3) {
						System.out.println("성공");
					}else {
						FindWord(i+1,s,grid,find,windex+1);
					}
				}
			}if(s!=0) {
				char a=grid[0][i].charAt(s-1);
				if(a==find.charAt(windex)) {
					if(windex==3) {
						System.out.println("성공");
					}else {
						FindWord(i,s-1,grid,find,windex+1);
					}
				}
			}if(s!=3) {
				char a=grid[0][i].charAt(s+1);
				if(a==find.charAt(windex)) {
					if(windex==3) {
						System.out.println("성공");
					}else {
						FindWord(i,s+1,grid,find,windex+1);
					}
				}
			}
	}
}
