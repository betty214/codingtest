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
		if(s.equals(t)) {
			return true;
		}else if(s.equals("*") || t.equals("*")){
			return true;
		}else {
			return false;
		}
	}
}
