package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class N으로표현 {
	    static int tempN;
	    static ArrayList<Integer>[] arr;
	    public static void main(String[] args)  throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine()); 
	        int number = Integer.parseInt(br.readLine()); 
	    	int answer = 0;
	        tempN = N;
	        arr = new ArrayList[8];
	        int flag=0;
	        for(int i=1; i<=8; i++) {
	            getNum(i);
	            if(arr[i].contains(number)) {
	            	answer=i;
	            	flag=1;
	            	break;
	            }
	        }
	        if(flag==0) {
	        	answer=-1;
	        }System.out.println(answer);
		}
	    public static ArrayList<Integer> getNum(int n) {
	        if((arr[n]!=null) && !arr[n].isEmpty())
	            return arr[n];
	        
	        int num = 0;
	        for(int i=0; i<n ; i++)
	            num = 10*num + tempN;
	        
	        ArrayList<Integer> temp = new ArrayList<>();
	        temp.add(num);
	        
	        for(int i=1; i<n; i++) {
	            int j = n-i;
	            ArrayList<Integer> from = getNum(i);
	            ArrayList<Integer> to = getNum(j);
	            for(int n1 : from) {
	                for(int n2 : to) {
	                    temp.add(n1+n2);
	                    temp.add(n1-n2);
	                    temp.add(n1*n2);
	                    if(n2!=0) temp.add(n1/n2);
	                }
	            }
	        }
	        return arr[n] = temp;
	    }
}
