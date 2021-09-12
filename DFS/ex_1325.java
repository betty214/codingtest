package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_1325 {
    static ArrayList<Integer> [] computer;
    static int []answer;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        computer = new ArrayList[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            if(computer[end]==null){
                computer[end]=new ArrayList<>();
            }
            computer[end].add(start);
        }
        answer=new int[N];
        for(int i=0;i<N;i++){
            visited=new boolean[N+1];
            visited[i+1]=true;
            DFS(i+1,i+1);
        }
        int max=0;
        for(int i=0;i<N;i++){
            if(max<answer[i]){
                max=answer[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(max == answer[i]){
                sb.append((i+1)+" ");
            }
        }
        System.out.println(sb.toString());
    }
    static void DFS(int s,int n){
        if(computer[n]!=null){
            for(int i=0;i<computer[n].size();i++){
                if(!visited[computer[n].get(i)]){
                    visited[computer[n].get(i)]=true;
                    answer[s-1]++;
                    DFS(s,computer[n].get(i));
                }
            }
        }
    }
}
