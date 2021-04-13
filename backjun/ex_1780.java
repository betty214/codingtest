package backjun;

import java.util.Scanner;

public class ex_1780 {
	public static int N;
	public static int [][] arr;
	public static int num0=0;
	public static int num1=0;
	public static int minus=0;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr=new int[N][N];
        for (int i = 0; i < N; i++) {
        	for(int j=0;j<N;j++) {
        		arr[i][j]=sc.nextInt();
        	}
        }
        DFS(N,0,0);
        System.out.println(minus);
        System.out.println(num0);
        System.out.println(num1);
    }
    
    public static boolean check(int n,int si, int sj) {
    	int flag=arr[si][sj];
        for(int i=si;i<n+si;i++) {
        	for(int j=sj;j<n+sj;j++) {
        		if(flag!=arr[i][j]) {
        			return false;
        		}
        	}
        }return true; 
    }
    public static void find(int n,int si, int sj) {
        for(int i=si;i<n+si;i++) {
        	for(int j=sj;j<n+sj;j++) {
        		if(arr[i][j]==-1) {
        			minus++;
        		}else if(arr[i][j]==0) {
        			num0++;
        		}else if(arr[i][j]==1) {
        			num1++;
        		}
        	}
        }
    }
    public static void DFS(int n, int si, int sj) {
        if (check(n,si,sj)) {
        	if(arr[si][sj]==-1) {
    			minus++;
    		}else if(arr[si][sj]==0) {
    			num0++;
    		}else if(arr[si][sj]==1) {
    			num1++;
    		}
        }else {
        	int m=n/3;
        	if(m==1) {
        		find(3,si,sj);
        	}else {
        		for(int i=si;i<si+n;i+=m) {
            		for(int j=sj;j<sj+n;j+=m) {
            			DFS(m,i,j);
            		}
            	}
        	}
        }
    }
}
