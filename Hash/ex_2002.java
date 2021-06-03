package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ex_2002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			map.put(in, i + 1);
		}
		int[] out = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			out[i] = map.get(input);
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (out[i] > out[j]) {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}
