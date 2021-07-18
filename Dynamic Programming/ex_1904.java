package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_1904 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []DP=new int[N];
        for(int i=0;i<N;i++) {
        	if(i==0) {
        		DP[i]=1;
        	}else if(i==1) {
        		DP[i]=2;
        	}else {
        		DP[i]=(DP[i-1]+DP[i-2])%15746;
        	}
        }System.out.println(DP[N-1]%15746);
	}
}
