package backjun;

import java.util.Scanner;

public class ex_10830 {
	public static int N,sum;
	public static long [][] arr;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		arr=new long[N][N];
        for (int i = 0; i < N; i++) {
        	for(int j=0;j<N;j++) {
        		arr[i][j]=sc.nextLong();
        	}
        }arr = square(B);
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            System.out.print(arr[i][j] % 1000 + " ");
          }System.out.println();
        }
	}
	public static long[][] square(long index) {
	    long[][] result = new long[N][N];
	    long[][] temp = new long[N][N];

	    if(index == 1) {
	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          result[i][j] = arr[i][j] % 1000;
	        }
	      }
	    }else if(index % 2 == 0) {
	      temp = square(index/2);
	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          for (int k = 0; k < N; k++) {
	        	  sum += temp[i][k] * temp[k][j];
	          }
	          result[i][j] = sum % 1000;
	          sum=0;
	        }
	      }
	    }else {
	      temp = square(index-1);
	      for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	          for (int k = 0; k < N; k++) {
	        	  sum += temp[i][k] * arr[k][j];
	          }
	          result[i][j] = sum % 1000;
	          sum=0;
	        }
	      }
	    }
	    return result;
	  }
}
