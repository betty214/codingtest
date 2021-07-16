import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    int[] visited;
    public int solution(int n, int[][] edge) {
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            g.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {    
            g.get(edge[i][0]).add(edge[i][1]);
            g.get(edge[i][1]).add(edge[i][0]);
        }
        int answer = bfs();
        return answer;
    }int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        int cnt = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int adj : g.get(now)) {
                    if (visited[adj]==0) {
                        temp.add(adj);
                        visited[adj] = 1;
                    }
                }
            }
            if (temp.isEmpty()) 
                break;
            q.addAll(temp);
            System.out.println(q);
            cnt = temp.size();
        }
        return cnt;
    }
}