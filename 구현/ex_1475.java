package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_1475 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] num= br.readLine().toCharArray();
		int []set =new int[10];
		int max=0;int temp=0;
		for(int i=0;i<num.length;i++) {
			int x =Character.getNumericValue(num[i]);
			set[x]++;
		}
		int six=set[6];
		set[6]=0;
		int nine=set[9];
		set[9]=0;
		for(int i=0;i<10;i++) {
			if(max<set[i]) {
				max=set[i];
			}
		}if(six>0&&nine>0) {
				temp=(six+nine)/2;
				if((six+nine)%2==1){
					temp++;
				}
			
		}else if(six>0&&nine==0) {
			temp=six/2;
			if(six%2==1){
				temp++;
			}
		}else if(six==0&&nine>0) {
			temp=nine/2;
			if(nine%2==1){
				temp++;
			}
		}
		if(temp>max) {
			max=temp;
		}
		System.out.print(max);
	}
}
