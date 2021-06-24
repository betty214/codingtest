package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ex_9251 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int index=0;int count=0;
        for(int i=0;i<s1.length();i++) {
        	if(s2.indexOf(s1.substring(i, i+1))==-1) {
        		continue;
        	}else {
        		count++;
        		index=s2.indexOf(s1.substring(i, i+1));
        		if(index>=s2.length()) {
        			break;
        		}
        		s2=s2.substring(index+1,s2.length());
        	}
        }System.out.println(count);
	}
}
