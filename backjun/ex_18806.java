package backjun;

import java.util.Scanner;

public class ex_18806 {
	public static int count=0;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        boolean what = check(S,T);
        System.out.println(what);
	}
	public static void insert() {
		
	}
	public static void delete() {
		
	}
	public static void trade() {
		
	}
	public static boolean check(String s, String t) {
		int slen =s.length();
		int tlen =t.length();
		int nth=0;
		int skip=0;
		
		while (nth < slen && nth < tlen && (s.charAt(nth) == '?' || s.charAt(nth) == t.charAt(nth) || t.charAt(nth) == '?') ) {
			System.out.println(s.charAt(nth)+" "+nth);
			nth ++;			
		}if (slen == nth && nth == tlen) {
			return true;
		}else if (s.charAt(nth) == '*' ||t.charAt(nth) == '*') {
			return true;
		}return false;
	}
}
