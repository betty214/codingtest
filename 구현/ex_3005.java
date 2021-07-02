package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_3005 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][]list=new char[R][C];
		ArrayList <String>word=new ArrayList<String>(); 
		for(int i=0;i<R;i++) {
			list[i]=br.readLine().toCharArray();
		}
		for(int i=0;i<R;i++) {
			String temp[] = String.valueOf(list[i]).split("#");
			for(int j=0;j<temp.length;j++) {
				if(temp[j].length()>1) {
					word.add(temp[j]);
				}
			}
		}for(int i=0;i<C;i++) {
			String temp="";
			for(int j=0;j<R;j++) {
				temp+= Character.toString(list[j][i]);
			}
			String t[]=temp.split("#");
			for(int k=0;k<t.length;k++) {
				if(t[k].length()>1) {
					word.add(t[k]);
				}
			}
		}
		Collections.sort(word);
		System.out.println(word.get(0));
	}
}
