package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ex_1620 {
	public static HashMap<Integer,String> map = new HashMap<>();
	public static HashMap<String, Integer> map2 = new HashMap<>();
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			map.put(i+1,input);
			map2.put(input, i+1);
		}
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			getKey(input);
		}
	}public static String getKey(String value) {
        if(value.charAt(0)>='0'&&value.charAt(0)<='9') {
			int n = Integer.parseInt((String) value);
			System.out.println(map.get(n));
        }else{
        	System.out.println(map2.get(value));
        }return null;
    }
}
