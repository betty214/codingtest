package eper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_nex3_2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int []answer=new int[n];
		String an="";
        String []cmd=new String [9];
        int tempi=0;
        int temp2i=k;
        int max=n;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        for(int i=0;i<9;i++) {
        	cmd[i]=br.readLine();
        }
        for(int i=0;i<n;i++) {
        	temp2.add(i);
        }
        for(int i=0;i<cmd.length;i++) {
        	if(cmd[i].charAt(0)=='D') {
        		int m=Character.getNumericValue(cmd[i].charAt(2));
        		int x=temp2i+=m;
        		temp2i=temp2.get(x);
        	}else if(cmd[i].charAt(0)=='U') {
        		int y=Character.getNumericValue(cmd[i].charAt(2));
        		int x=temp2i-=y;
        		temp2i=temp2.get(x);
        	}else if(cmd[i].charAt(0)=='C') {
        		if(temp2i==max-1) {
        			temp2.remove(temp2i);
        			temp.add(temp2i);
        			tempi++;
        			temp2i--;
        			max--;
        		}else {
        			temp2.remove(temp2i);
        			temp.add(temp2i);
        			tempi++;
        			temp2i++;
        			max--;
        		}
        	}else if(cmd[i].charAt(0)=='Z') {
        		int x=temp.get(tempi-1);
        		temp.remove(tempi-1);
        		temp2.add(temp2i, x);
        		tempi--;
        	}
        	for(int u=0;u<max;u++) {
            	System.out.print(temp2.get(u));
            }System.out.println(" "+temp2i);
        }
        /*for(int u=0;u<n;u++) {
    		if(answer[u]==0) {
    			an+="O";
    		}else {
    			an+="X";
    		}
    	}System.out.println(an);*/
	}
}
