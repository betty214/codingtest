package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class ex_2644 {
    static int ans = -1;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
 
        ArrayList<ArrayList<Integer>> people = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            people.add(new ArrayList<>());
        }
 
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
 
            people.get(tx).add(ty);
            people.get(ty).add(tx);
        }
        System.out.println(people);
        visited = new boolean[N + 1];
        DFS(people, x, y, 0);
 
        System.out.println(ans);
    }
    public static void DFS(ArrayList<ArrayList<Integer>> people,int now, int find, int count) {
        visited[now] = true;
        for (int i : people.get(now)) {
            if (!visited[i]) {
                if (i == find) {
                    ans = count + 1;
                    return;
                }
                DFS(people, i, find, count + 1);
            }
        }
    }
}