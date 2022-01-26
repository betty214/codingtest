package day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_3830 {
    private static class Node implements Comparable<Node>{
        int parent;
        int diff;
        public Node(int parent, int diff){
            this.parent=parent;
            this.diff=diff;
        }
        @Override
        public int compareTo(Node o) {
            return parent-o.parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "parent=" + parent +
                    ", diff=" + diff +
                    '}';
        }
    }
    static long[]diff;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day8/3830.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while(n!=0){
            diff = new long [n + 1];
            parent = new int [n + 1];
            for (int i = 1 ; i <= n ; i++) {
                parent[i] = i;
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(op.equals("!")){
                    int w = Integer.parseInt(st.nextToken());
                    union(a,b,w);
                }else{
                    if(find(a) == find(b)) {
                        System.out.println(diff[b]-diff[a]);
                    } else {
                        System.out.println("UNKNOWN");
                    }
                }
            }
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
    }static void union(int a, int b, int w) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return;
        }

        diff[parentB] = diff[a] - diff[b] + w;
        parent[parentB] = parentA;
    }
    static int find(int i) {
        if(parent[i] == i) {
            return i;
        } else {
            int parentIndex = find(parent[i]);
            diff[i] += diff[parent[i]];
            return parent[i] = parentIndex;
        }
    }
}
