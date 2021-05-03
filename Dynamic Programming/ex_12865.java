package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class ex_12865 {
	public static int [][]DV;
	public static int []W;
	public static int []V;
	public static int K,N;
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W=new int [N+1];
        V=new int [N+1];

        K = sc.nextInt();
        DV=new int [N+1][K+1];
        for(int a[]:DV) {
        	Arrays.fill(a, -1);
        }
        for(int i=1;i<=N;i++) {
        	W[i]=sc.nextInt();
        	V[i]=sc.nextInt();
        }
        System.out.println(DP(N,K));
	}public static int DP(int index, int mw) {
		if(index<1) {
			return 0;
		}
		if(DV[index][mw]==-1) {
			if(W[index]>mw) {
				DV[index][mw]=DP(index-1,mw);
			}else {
				DV[index][mw]=Math.max(DP(index-1,mw), V[index]+DP(index-1,mw-W[index]));
			}
		}
		return DV[index][mw];
	}
}
