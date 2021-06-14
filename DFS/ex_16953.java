package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_16953 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long A=Integer.parseInt(st.nextToken());
		long B=Integer.parseInt(st.nextToken());
		int count=1;
		int flag=0;
		while(B!=A) {
			if(B<A) {
				flag=1;
				break;
			}
			if(B%10==1) {
				B/=10;
				count++;
			}else {
				B/=2;
				count++;
			}
		}if(flag==0) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}	
	}
}
