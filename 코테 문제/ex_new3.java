package eper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_new3 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int []answer=new int[n];
		String an="";
        String []cmd=new String [9];
        int tempi=0;
        ArrayList<Integer> temp = new ArrayList<Integer>(); 
        for(int i=0;i<9;i++) {
        	cmd[i]=br.readLine();
        }
        for(int i=0;i<cmd.length;i++) {
        	if(cmd[i].charAt(0)=='D') {
        		int m=Character.getNumericValue(cmd[i].charAt(2));
        		int index=0;
        		while(index<m&&k<n) {
        			if(answer[k++]==0) {
        				index++;
        				if(k==n-1&&answer[k]==1&&index==m) {
        					k--;
        				}
        			}
        		}
        	}else if(cmd[i].charAt(0)=='U') {
        		int y=Character.getNumericValue(cmd[i].charAt(2));
        		int index=1;
        		while(index<=y&&k>0) {
        			if(answer[k--]==0) {
        				index++;
        				if(index==y&&answer[k]==1) {
        					index--;
        				}
        			}
        		}
        	}else if(cmd[i].charAt(0)=='C') {
        		if(k==n-1) {
        			answer[k]=1;
        			temp.add(k);
        			tempi++;
        			k--;
        		}else {
        			answer[k]=1;
        			temp.add(k);
        			tempi++;
        			k++;
        		}
        	}else if(cmd[i].charAt(0)=='Z') {
        		int x=temp.remove(tempi-1);
        		tempi--;
        		answer[x]=0;
        	}
        	
        }for(int u=0;u<n;u++) {
    		if(answer[u]==0) {
    			an+="O";
    		}else {
    			an+="X";
    		}
    	}System.out.println(an);
	}
}
