package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_1316 {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer=0;
		for(int i=0;i<N;i++) {
			char[] word = br.readLine().toCharArray();
			ArrayList<Character>list = new ArrayList<Character>();
			int f=0;
			for(int j=0;j<word.length;j++) {
				char check=word[j];
				if(list.contains(check))
					continue;
				else
					list.add(check);
			}for(int j=0;j<list.size();j++) {
				char c = list.get(j);
				int flag=0;
				for(int k=0;k<word.length;k++) {
					if(flag==0) {
						if(word[k]==c) {
							flag=1;
						}
					}else if(flag==1){
						if(word[k]!=c) {
							flag=2;
						}
					}else if(flag==2) {
						if(word[k]==c) {
							f=1;
						}
					}
				}
			}if(f==0) {
				answer++;
			}f=0;
		}System.out.println(answer);
	}
}
