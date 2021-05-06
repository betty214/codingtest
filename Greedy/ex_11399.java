package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_11399 {
	public static int []P;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		P=new int [N];
		for(int i=0;i<N;i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++){
				sum+=P[j];
			}
		}System.out.println(sum);
	}
}
