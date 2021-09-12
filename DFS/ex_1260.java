package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_1260 {
    static int N,M,V;
    static ArrayList<Integer>[] graph;
    static boolean[]visited;
    static ArrayList<Integer> dfs_answer, bfs_root,bfs_answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dfs_answer = new ArrayList<>();
        bfs_answer = new ArrayList<>();
        bfs_root = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        for(int i = 0; i < N+1; i++) {
            Collections.sort(graph[i]);
        }
        DFS(V);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< dfs_answer.size(); i++){
            sb.append(dfs_answer.get(i)+" ");
        }
        System.out.println(sb.toString());
        visited = new boolean[N+1];
        bfs_root.add(V);
        while(bfs_root.size()!=0){
            BFS();
        }
        sb = new StringBuilder();
        for(int i=0; i< bfs_answer.size(); i++){
            sb.append(bfs_answer.get(i)+" ");
        }
        System.out.println(sb.toString());
    }static void DFS(int x){
        if(!visited[x]){
            visited[x]=true;
            dfs_answer.add(x);
            for(int i=0;i<graph[x].size();i++){
                DFS(graph[x].get(i));
            }
        }
    }static void BFS(){
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<bfs_root.size();i++){
            if(!visited[bfs_root.get(i)]){
                visited[bfs_root.get(i)]=true;
                bfs_answer.add(bfs_root.get(i));
                for(int j=0;j<graph[bfs_root.get(i)].size();j++){
                    if(!visited[graph[bfs_root.get(i)].get(j)]){
                        temp.add(graph[bfs_root.get(i)].get(j));
                    }
                }
            }
        }
        bfs_root.clear();
        bfs_root=(ArrayList<Integer>) temp.clone();
    }
}
