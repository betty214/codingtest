package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1766 {
    static int N;
    static int M;
    static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        indegree= new int[N+1];

        for(int i=0; i<N+1; i++)
            list.add(new ArrayList<Integer>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            indegree[v2]++;
        }
        topologicalSort(list);
    }

    static void topologicalSort(List<List<Integer>> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=1; i<N+1; i++) {
            if(indegree[i] == 0)
                pq.offer(i);
        }
        while(!pq.isEmpty()) {
            int node = pq.poll();
            for(Integer i : list.get(node)) {
                indegree[i]--;
                if(indegree[i] == 0)
                    pq.offer(i);
            }
            System.out.print(node + " ");
        }
    }
}
