package backjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex_4386{
    static int parent[];
    static class Star{
        int index;
        double x, y;
        
        Star(int n, double x, double y) {
            index = n;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge> {
        int v1, v2;
        double weight;
        
        Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return Double.compare(weight, e.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Star star[] = new Star[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double weight = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            star[i] = new Star(i, a, b);
        }
        for(int i = 0; i < n-1; i++) {
        	for(int j = i+1; j < n; j++) {
        		pq.offer(new Edge(i, j, Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2))));
        	}
        }
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            System.out.println(now.v1+" "+now.v2+" "+find(now.v1)+" "+find(now.v2));
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        System.out.println(Math.round(weight*100)/100.0);
    }
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 > p2) {
        	parent[p1] = p2;
        }else {
        	parent[p2] = p1;
        }
    }
    public static int find(int n) {
        if(parent[n] == n) {
        	return n;
        }
        return parent[n] = find(parent[n]);
    }
}