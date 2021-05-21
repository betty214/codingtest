package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_13305 {
	public static int []price,distance;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringTokenizer st2=new StringTokenizer(br.readLine());
		distance=new int [N];
		price=new int [N];
		int min=1000000001;
		int mflag=0;int d=0; 
		long sum=0;
		for(int i=0;i<N-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			price[i]=Integer.parseInt(st2.nextToken());
			if(price[i]<min&&i!=N-1) {
				min=price[i];
				mflag=i;
			}
		}
		for(int i=mflag;i<N-1;i++) {
			d+=distance[i];
		}
		sum+=d*min;
		while(mflag!=0) {
			int tempd=findDistance(mflag);
			mflag=findMin(mflag);
			sum+=tempd*price[mflag];
		}
		System.out.println(sum);
	}public static int findMin(int mflag) {
		int min=price[0];
		int flag=0;
		for(int i=0;i<mflag;i++) {
			if(price[i]<min&&i!=mflag-1) {
				min=price[i];
				flag=i;
			}
		}
		return flag;
	}
	public static int findDistance(int mflag) {
		int d=0;
		for(int i=0;i<mflag;i++) {
			d+=distance[i];
		}
		return d;
	}
}
