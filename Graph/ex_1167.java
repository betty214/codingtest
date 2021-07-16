package backjun;

import java.util.*;
 
public class ex_1167 {    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    public static class Node {
        int end;
        int cost;
        
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        list = new ArrayList[n + 1]; 
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            int start = scan.nextInt();
            while(true) {
                int end = scan.nextInt();
                if(end == -1) {
                	break;
                }
                int cost = scan.nextInt();
                list[start].add(new Node(end, cost));
            }
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        visited = new boolean[n + 1];
        dfs(node, 0);
        
        System.out.println(max);
    }
    
    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(visited[n.end] == false) {
                dfs(n.end, n.cost + len);
                visited[n.end] = true;
            }
        }
    }
    
    
}
