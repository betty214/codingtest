package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_1325 {
    static ArrayList<Integer> [] computer;
    static int [][]answer;
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
        answer=new int[N+1][2];
        for(int i=0;i<N;i++){
            answer[i][0]=i+1;
            answer[i][1]=1;
        }
        for(int i=0;i<N;i++){
            DFS(i+1,i+1);

        }
        int max=0;
        for(int i=0;i<N;i++){
            if(max<answer[i][1]){
                max=answer[i][1];
            }
        }
        ArrayList<Integer> answer_list=new ArrayList<>();
        for(int i=0;i<N;i++){
            if(answer[i][1]==max){
                answer_list.add(answer[i][0]);
            }
        }Collections.sort(answer_list);
        for(int i=0;i<answer_list.size();i++) {
            System.out.println(answer_list.get(i));
        }
    }
    static void DFS(int s,int n){
        if(computer[n]==null){
            return;
        }else{
            for(int i=0;i<computer[n].size();i++){
                answer[s-1][1]++;
                DFS(s,computer[n].get(i));
            }
        }
    }
}
