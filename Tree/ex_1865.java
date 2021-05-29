package backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1865 {
	private static final int INF = Integer.MAX_VALUE;
	static int N, M, W;
	static ArrayList<ArrayList<Road>> roads;
	static int[] dist;
	static class Road {
		int end;
		int cost;

		public Road(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dist = new int[N + 1];
			roads = new ArrayList<>();
			for (int j = 0; j <= N; j++) {
                roads.add(new ArrayList<>());
            }
			
			for (int j = 0; j < M + W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if (j < M) {
					roads.get(S).add(new Road(E, T));
					roads.get(E).add(new Road(S, T));
				} else {
					roads.get(S).add(new Road(E, -T));
				}
			}
			Arrays.fill(dist, INF);

            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                if (bellmanFord(j)) {
                    flag = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (!flag) {
            	System.out.println("NO");
            }
		}
	}

	public static boolean bellmanFord(int start) {
        dist[start] = 0; 
        boolean update = false;
        
        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
            	for (Road road : roads.get(j)) {
                    if (dist[j] != INF && dist[road.end] > dist[j] + road.cost) {
                        dist[road.end] = dist[j] + road.cost;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        
        if (update) {
            for (int i = 1; i <= N; i++) {
            	for (Road road : roads.get(i)) {
                    if (dist[i] != INF && dist[road.end] > dist[i] + road.cost) {
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
}
