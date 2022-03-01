package eper;

import java.util.Scanner;

public class ex_new {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int n = 0;
        String ns = "";
        int index=0;
        while(index<s.length()) {
        	if(s.charAt(index)=='o') {
            	ns+="1";
            	index+=3;
            }else if(s.charAt(index)=='t') {
            	if(s.charAt(index+1)=='w') {
            		ns+="2";
                	index+=3;
            	}else {
            		ns+="3";
                	index+=5;
            	}
            }else if(s.charAt(index)=='f') {
            	if(s.charAt(index+1)=='o') {
            		ns+="4";
                	index+=4;
            	}else {
            		ns+="5";
                	index+=4;
            	}
            }else if(s.charAt(index)=='s') {
            	if(s.charAt(index+1)=='i') {
            		ns+="6";
                	index+=3;
            	}else {
            		ns+="7";
                	index+=5;
            	}
            }else if(s.charAt(index)=='e') {
            	ns+="8";
            	index+=5;
            }else if(s.charAt(index)=='n') {
            	ns+="9";
            	index+=4;
            }else if(s.charAt(index)=='z') {
            	ns+="0";
            	index+=4;
            }else {
            	ns+=s.charAt(index);
            	index++;
            }
        }
        System.out.println(ns);
	}
}
