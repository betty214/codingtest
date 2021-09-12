package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex_5014 {
    static int[] elevator;
    static boolean[] visited;
    static int F,G,S,U,D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        elevator = new int[F+1];
        Arrays.fill(elevator, -1);
        visited = new boolean[F+1];
        bfs(S);
        if(elevator[G] == -1 && S!=G) {
            System.out.println("use the stairs");
        } else {
            System.out.println(elevator[G]+1);
        }
    } static void bfs(int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int t = q.remove();
            if(t == G) {
                return;
            }
            if(t+U <= F && !visited[t+U]) {
                q.add(t+U);
                elevator[t+U] = elevator[t] + 1;
                visited[t+U] = true;
            }
            if(t-D >= 1 && !visited[t-D]) {
                q.add(t-D);
                elevator[t-D] = elevator[t] + 1;
                visited[t-D] = true;
            }
        }
    }
}
