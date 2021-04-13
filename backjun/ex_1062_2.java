package backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ex_1062_2 {
    static boolean[] visited;
    static String[] word;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
    	Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    String letter[] = new String[n];
	    char spell[][] = new char[50][15];
	    int length[]=new int[n];
	    int flag=0,f=0,max=0,lflag=0;
	    for(int i=0;i<n;i++) {
	    	letter[i]= scan.next();
	    }
        visited = new boolean[26];
        word = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        /* 무조건 배워야하는 단어 */
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for(int i=0;i<n;i++) {
	    	for(int j=0;j<letter[i].length();j++) {
	    		char y=letter[i].charAt(j);
	    		if(y!='a'&&y!='n'&&y!='t'&&y!='i'&&y!='c') {
	    			for(k=0;k<spell[i].length;k++) {
	    				if(y==spell[i][k]) {
	    					f=1;
	    				}
	    			}
	    			if(f==0) {
	    				spell[i][flag]=y;
	    				lflag++;
		    			flag++;
	    			}f=0;
	    		}length[i]=lflag;
	    	}flag=0;
	    	lflag=0;
	    }
        for(int i=0;i<n;i++) {
        	word[i]=String.valueOf(spell[i]);
        	System.out.println(word[i]);
        }
        check(0, 0,k,n);
        System.out.println(answer);
    }

    static void check(int alpha, int count,int k,int n) {
        if (count == k - 5) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;

                for (int j = 0; j < word[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!visited[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(temp, answer);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(i, count + 1,k,n);
                visited[i] = false;
            }
        }
    }

}