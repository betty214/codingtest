package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class ex_13414 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		for(int i=0;i<L;i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				int n = map.get(input);
				map.replace(input, i);
			}else {
				map.put(input, i);
			}
		}List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		int count=0;
		for(Entry<String, Integer> entry : list_entries) {
			System.out.println(entry.getKey());
			count++;
			if(count==K) {
				break;
			}
		}
	}
}
