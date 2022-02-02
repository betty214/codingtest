package day9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_3176 {
    private static class Node{
        int end;
        int dist;
        public Node(int end,int dist){
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day9/3176.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node>[]road=new ArrayList[n];
        int[][]LCA=new int[16][n];
        for(int i=0;i<n;i++){
            road[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            road[A].add(new Node(B,C));
            road[B].add(new Node(A,C));
            LCA[0][A]=B;
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
        }
    }
}
