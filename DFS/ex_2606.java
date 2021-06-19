package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class ex_2606 {
    static int ans = -1;
    static ArrayList<ArrayList<Integer>> virus;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        virus = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            virus.add(new ArrayList<>());
        }
 
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
 
            virus.get(tx).add(ty);
            virus.get(ty).add(tx);
        }
        visited = new boolean[N + 1];
        DFS(1);
        int count=-1;
        for(int i=0;i<visited.length;i++) {
        	if(visited[i]) {
        		count++;
        	}
        }System.out.println(count);
    }
    public static void DFS(int start) {
        visited[start] = true;
        for (int i : virus.get(start)) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}