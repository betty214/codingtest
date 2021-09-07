package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_9466 {
    static int[] student;
    static boolean[]visited,closed;
    static Stack<Integer> stack;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            visited = new boolean[N+1];
            closed = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }
            answer = N;
            for (int j = 1; j <= N; j++) {
                DFS(j);
            }
            System.out.println(answer);
        }
    }

    static void DFS(int index) {
        if(!visited[index]){
            visited[index] = true;
            int next = student[index];
            if(visited[next] != true){
                DFS(next);
            }else {
                if(closed[next] != true) {
                    answer--;
                    for(int i=next; i != index; i = student[i]){
                        answer--;
                    }
                }
            }
            closed[index] = true;
        }
    }
}
