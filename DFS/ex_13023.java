package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_13023 {
    static int N,M,answer;
    static ArrayList<Integer>[] friend;
    static boolean []visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            friend[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            friend[x].add(y);
            friend[y].add(x);
        }answer=0;
        for(int i=0;i<N;i++){
            DFS(i,1);
            if(answer==1){
                break;
            }
        }
        System.out.println(answer);
    }
    static void DFS(int n,int c){
        if(c==5){
            answer=1;
            return;
        }
            visited[n]=true;
            for(int i=0;i<friend[n].size();i++){
                int next=friend[n].get(i);
                if(!visited[next]){
                    DFS(next,c+1);
                }
            }visited[n]=false;
    }
}
