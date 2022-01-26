package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_5719 {
    private static class Node implements Comparable<Node>{
        int end;
        int dist;
        boolean isShortest;

        public Node(int end, int dist){
            this.end=end;
            this.dist=dist;
            this.isShortest = false;
        }

        @Override
        public int compareTo(Node o) {
            return dist-o.dist;
        }
    }
    private static int INF=Integer.MAX_VALUE;
    static int N,S,D;
    static ArrayList<Node>[]arr;
    static ArrayList<Integer>[] Tracking;
    static int[]answer;
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day8/5719.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        while(N!=0){
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            arr=new ArrayList[N];
            answer=new int[N];
            Tracking=new ArrayList[N];
            for(int i=0;i<N;i++){
                arr[i]=new ArrayList<>();
            }
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                arr[U].add(new Node(V,P));
            }
            findShort(S);
            if(answer[D] == INF) {
                System.out.println(-1);
                continue;
            }

            findEdge(D, S);
            findShort(S);

            if(answer[D] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(answer[D]);
            }
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
        }
    }static void findEdge(int now, int end) {
        if(now == end) {
            return;
        }

        for(int next : Tracking[now]) {
            for(int i = 0 ; i < arr[next].size() ; i++) {
                if(arr[next].get(i).end == now && arr[next].get(i).isShortest == false) {
                    arr[next].get(i).isShortest = true;
                    findEdge(next, end);
                }
            }
        }
    }static void findShort(int start){
        for(int i = 0 ; i < N ; i++) {
            Tracking[i] = new ArrayList<>();
        }
        Arrays.fill(answer,INF);
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));

        answer[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.dist > answer[now.end]) {
                continue;
            }
            for(Node next : arr[now.end]) {
                if(next.isShortest == true) continue;
                if(answer[next.end] == answer[now.end] + next.dist) {
                    Tracking[next.end].add(now.end);
                }
                if(answer[next.end] > answer[now.end] + next.dist) {
                    Tracking[next.end].clear();
                    Tracking[next.end].add(now.end);
                    answer[next.end] = answer[now.end] + next.dist;
                    pq.add(new Node(next.end, answer[next.end]));
                }
            }
        }
    }
}