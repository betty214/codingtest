package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_9996 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		int index=0;
		for(int i=0;i<pattern.length();i++) {
			if(pattern.substring(i,i+1).equals("*")) {
				index=i;
				break;
			}
		}
		String pre=pattern.substring(0,index);
		String post=pattern.substring(index+1,pattern.length());
		for(int i=0;i<N;i++) {
			String word =br.readLine();
			if(word.length()<pre.length()+post.length()) {
				System.out.println("NE");
			}else {
				String tpre=word.substring(0,index);
				String tpost=word.substring(word.length()-post.length(),word.length());
				if(tpre.equals(pre)&&tpost.equals(post)) {
					System.out.println("DA");
				}else {
					System.out.println("NE");
				}
			}
			}
	}
}
