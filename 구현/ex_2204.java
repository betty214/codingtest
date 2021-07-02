package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex_2204 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N!=0) {
			ArrayList<String>s= new ArrayList<String>();
			ArrayList<String>list = new ArrayList<String>();
			for(int i=0;i<N;i++) {
				String word = br.readLine();
				list.add(word);
				String w=word.toUpperCase();
				s.add(w);
			}Collections.sort(s);
			for(String x:list) {
				if(s.get(0).equalsIgnoreCase(x)) {
		            System.out.println(x);
		        }
			}
			N = Integer.parseInt(br.readLine());
		}
	}
}
