package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ex_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> fashion = new HashMap<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                if (fashion.get(key) != null) {
                    int prev = fashion.get(key)+1;
                    fashion.put(key, prev);
                } else {
                    fashion.put(key, 1);
                }
            }
            int answer = 1;
            for (String k : fashion.keySet()) {
                int v = fashion.get(k);
                answer *= (v+1);
            }
            System.out.println(answer - 1);
        }
    }
}
