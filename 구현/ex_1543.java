package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int count=0;
		if(s1.contains(s2)) {
			int len =s1.length();
			for(int i=0;i<len-s2.length()+1;) {
				String sub = s1.substring(i,i+s2.length());
				if(sub.equals(s2)) {
					count++;
					i+=s2.length();
				}else {
					i++;
				}
			}
		}System.out.println(count);
	}
}
