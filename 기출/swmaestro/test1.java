package swmaestro;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a=input.nextLine();
        char[] c = a.toCharArray();
        int b=input.nextInt();
        String []d=new String[b];
        String x=input.nextLine();
        for(int i=0;i<b;i++) {
        	d[i]=input.nextLine();
        }
        for(int i=0;i<c.length;i+=2) {
        	char e=c[i];
        	if(check1(e,d,b)) {
        		System.out.println(check2(e,d,b));
        	}
        }
	}
    public static boolean check1(char k, String[]d,int b) {
    	boolean flag=true;
    	for(int i=0;i<b;i++) {
    		if(d[i].charAt(2)==k) {
    			flag=false;
    			break;
    		}
    	}
    	return flag;
    }
    public static int check2(char k, String[]d,int b) {
    	int flag=0;
    	for(int i=0;i<b;i++) {
    		if(d[i].charAt(0)==k) {
    			check1(d[i].charAt(2),d,b);
    		}
    	}
    	return flag;
    }
}
