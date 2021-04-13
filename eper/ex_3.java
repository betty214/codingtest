package eper;
import java.util.Arrays;
import java.util.Scanner;

public class ex_3 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		if(Arrays.equals(array1, array2)) {
			System.out.println("T");
		}else {
			System.out.println("F");
		}
	}
}
