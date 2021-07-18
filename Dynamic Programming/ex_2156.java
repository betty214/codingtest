package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_2156 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] wine=new int[N];
        int []DP=new int[N];
        for (int i=0;i<N;i++) {
        	wine[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++) {
        	if(i==0) {
        		DP[i]=wine[i];
        	}else if(i==1) {
        		DP[i]=wine[i-1]+wine[i];
        	}else if(i==2) {
        		int temp=Math.max(wine[i-1]+wine[i],wine[i-2]+wine[i]);
        		DP[i]=Math.max(temp,wine[i-2]+wine[i-1]);
        	}else {
        		int temp=Math.max(wine[i-1]+wine[i]+DP[i-3], DP[i-1]);
        		DP[i]=Math.max(temp, DP[i-2]+wine[i]);
        	}
        }System.out.print(DP[N-1]);
	}
}
