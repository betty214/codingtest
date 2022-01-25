package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_1922{
    static int parent[];

    static class Computer implements Comparable<Computer> {
        int start, end, cost;

        Computer(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Computer c) {
            return cost- c.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day6/1922.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int answer = 0;
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Computer(start, end, cost));
        }
        while (!pq.isEmpty()) {
            Computer now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                answer += now.cost;
            }
        }
        System.out.println(answer);
    }
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 > p2) parent[p1] = p2;
        else parent[p2] = p1;
    }
    public static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}