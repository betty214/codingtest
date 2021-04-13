package backjun;

import java.util.*;

public class ICPC_A {
	public static String []word;
	public static String []rword;
	public static int []visit;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int m = scan.nextInt();
	    word=new String[n];
	    rword=new String[n];
	    visit=new int[n];
	    int k=0;
		for (int i = 0; i < n; i++) {
			visit[i]=0;
		}
		for (int i = 0; i < n; i++) {
			word[i]=scan.next();
			if(word[i].length()>=m) {
				k++;
			}
		}
		insertWord(n, k,m);
		//printWord(n,m);
	}
	public static class Word implements Comparable{
		private String name;
	    private int visit;
	    
	    public Word(String name, int visit){
	        this.name = name;
	        this.visit= visit;
	    }
	    public String print(){
	        return word+"("+visit+")";
	    }

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return name.compareTo(((Word)o).name);
		}
	}
	public static void printWord(int n, int m) {
		Arrays.sort(rword);
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
	public static void insertWord(int n, int k, int m) {
		int count=0,flag=0;
		for (int i = 0; i < k; i++) {
			rword[i]="";
		}
		for (int i = 0; i < n; i++) {
			if(word[i].length()>=m) {
				for(int j=0;j<k;j++) {
					if(rword[j].equals(word[i])){
						flag=1;
						visit[j]++;
					}
				}
				if(flag==0) {
					rword[count]=word[i];
					visit[count]++;
					count++;
				}flag=0;
			}
		}
		Word[] arr = { new Word("apple", 2), new Word("sand",3), new Word("append", 1)};

		Arrays.sort(arr); // 오름차순 정렬

		for (Word i : arr) { // 오름차순 출력
			System.out.print("[" + i.print() + "]");
		}
	}

}
