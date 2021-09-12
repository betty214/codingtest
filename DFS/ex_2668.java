package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex_2668 {
    static int []number;
    static boolean []visited;
    static int last;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        number=new int[N+1];
        visited=new boolean[N+1];
        for(int i=0;i<N;i++){
            number[i+1]=Integer.parseInt(br.readLine());
        }
        list = new ArrayList<Integer>();
        for(int i=1;i<=N;i++){
            visited[i] = true;
            DFS(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }static void DFS(int index,int start){
        if (!visited[number[index]]) {
            visited[number[index]] = true;
            DFS(number[index],start);
            visited[number[index]] = false;
        }
        if (number[index] == start) {
            list.add(start);
        }
    }
}
