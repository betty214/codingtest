package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_15649 {
    static int []num;
    static boolean []visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num = new int[M];
        visited = new boolean[N];
        DFS(0);
    }public static void DFS(int depth) {
        if (depth == M) {
            for (int i=0;i<num.length;i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[depth] = i + 1;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
