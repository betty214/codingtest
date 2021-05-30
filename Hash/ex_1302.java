package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class ex_1302 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				int n = map.get(input);
				map.replace(input, n+1);
			}else {
				map.put(input, 1);
			}
		}
		TreeMap<String,Integer> tm = new TreeMap<String,Integer>(map);
		Iterator<String> iteratorKey = tm.keySet( ).iterator( );   
		int max=0;
		while(iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			int n = map.get(key);
		    if(n>max) {
		    	max=n;
		    }
		}iteratorKey = tm.keySet( ).iterator( );   
		while(iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			int n = map.get(key);
		    if(n==max) {
		    	System.out.println(key);
		    	break;
		    }
		}
	}
}
