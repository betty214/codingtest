package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex_1339 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String []s = new String[N];
		int []alpha=new int[26];
		for(int i=0;i<N;i++) {
			s[i]=br.readLine();
			for(int j=0;j<s[i].length();j++) {
				char c=s[i].charAt(j);
				int n=c-'A';
				int ten=made(s[i].length()-j);
				alpha[n]+=ten;
			}
		}
		Arrays.sort(alpha);
		int score=9;
		int sum=0;
		for(int i=25;i>=0;i--) {
			if(alpha[i]!=0) {
				sum+=alpha[i]*score;
				score--;
			}else {
				break;
			}
		}System.out.println(sum);
		
	}
	public static int made(int n) {
		int res=1;
		for(int i=0;i<n-1;i++) {
			res*=10;
		}return res;
	}
}
