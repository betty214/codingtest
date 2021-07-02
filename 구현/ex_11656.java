package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex_11656 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		ArrayList <String> post =new ArrayList<String>();
		int len =word.length();
		for(int i=1;i<=len;i++) {
			String p = word.substring(len-i,len);
			post.add(p);
		}
		Collections.sort(post);
		for(String x : post) {
			System.out.println(x);
		}
	}
}
